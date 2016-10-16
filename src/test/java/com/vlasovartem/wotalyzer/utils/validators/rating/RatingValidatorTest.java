package com.vlasovartem.wotalyzer.utils.validators.rating;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.BATTLE_TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.DATE_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.prepareDate;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateBattleType;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class RatingValidatorTest {

    @Test
    public void validateBattleTypeTest() {
        assertTrue(validateBattleType().apply(prepareMap(BATTLE_TYPE_PARAM, "random")));
    }

    @Test
    public void validateBattleTypeInvalidValueTest() {
        Map<String, Object> objectMap = prepareMap(BATTLE_TYPE_PARAM, "invalid");
        validateBattleType().apply(objectMap);
        Assert.assertEquals("default", objectMap.get(BATTLE_TYPE_PARAM));
    }

    @Test
    public void validateDateTest() {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(2);
        Map<String, Object> objectMap = prepareMap(DATE_PARAM, localDateTime);
        validateDate().apply(objectMap);
        assertEquals(objectMap.get(DATE_PARAM), prepareDate(localDateTime));
    }

    @Test
    public void validateDateIncorrectTypeTest() {
        Map<String, Object> objectMap = prepareMap(DATE_PARAM, 33);
        validateDate().apply(objectMap);
        assertEquals(objectMap.get(DATE_PARAM), prepareDate(LocalDateTime.now().minusDays(1)));
    }

    @Test
    public void validateDateInvalidDateValueGreaterThanTodayTest() {
        Map<String, Object> objectMap = prepareMap(DATE_PARAM, LocalDateTime.now().plusDays(1));
        validateDate().apply(objectMap);
        assertEquals(objectMap.get(DATE_PARAM), prepareDate(LocalDateTime.now().minusDays(1)));
    }

    @Test
    public void validateDateInvalidDateValueLessThanSevenDaysTest() {
        Map<String, Object> objectMap = prepareMap(DATE_PARAM, LocalDateTime.now().minusDays(8));
        validateDate().apply(objectMap);
        assertEquals(objectMap.get(DATE_PARAM), prepareDate(LocalDateTime.now().minusDays(1)));
    }

}
