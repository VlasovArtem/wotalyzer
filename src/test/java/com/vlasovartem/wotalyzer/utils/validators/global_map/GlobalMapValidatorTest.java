package com.vlasovartem.wotalyzer.utils.validators.global_map;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class GlobalMapValidatorTest {

    @Test
    public void validateFrontIdParameterStringTest() {
        assertTrue(validateFrontIdParameter().apply(prepareMap(FRONT_ID_PARAM, "test")));
    }

    @Test
    public void validateFrontIdParameterListTest() {
        assertTrue(validateFrontIdParameter().apply(prepareMap(FRONT_ID_PARAM, Collections.singletonList("test"))));
    }

    @Test
    public void validateFrontIdParameterListInvalidSizeTest() {
        assertFalse(validateFrontIdParameter().apply(prepareMap(FRONT_ID_PARAM, Arrays.asList("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"))));
    }

    @Test
    public void validateVehicleLevelParameterStringTest() {
        assertTrue(validateVehicleLevelParameter().apply(prepareMap(VEHICLE_LEVEL_PARAM, "6")));
    }

    @Test
    public void validateVehicleLevelParameterListTest() {
        assertTrue(validateVehicleLevelParameter().apply(prepareMap(VEHICLE_LEVEL_PARAM, Arrays.asList("6", "10"))));
    }

    @Test
    public void validateVehicleLevelParameterInvalidTypeTest() {
        assertFalse(validateVehicleLevelParameter().apply(prepareMap(VEHICLE_LEVEL_PARAM, 6)));
    }

    @Test
    public void validateVehicleLevelParameterInvalidStringValueTest() {
        assertFalse(validateVehicleLevelParameter().apply(prepareMap(VEHICLE_LEVEL_PARAM, "7")));
    }

    @Test
    public void validateVehicleLevelParameterInvalidListValueTest() {
        assertFalse(validateVehicleLevelParameter().apply(prepareMap(VEHICLE_LEVEL_PARAM, Arrays.asList("6", "7"))));
    }

    @Test
    public void validateClanIDParameterStringTest() {
        assertTrue(validateClanIDParameter().apply(prepareMap(CLAN_ID_PARAM, "test")));
    }

    @Test
    public void validateClanIDParameterListTest() {
        assertTrue(validateClanIDParameter().apply(prepareMap(CLAN_ID_PARAM, Collections.singletonList("test"))));
    }

    @Test
    public void validateClanIDParameterListInvalidSizeTest() {
        assertFalse(validateClanIDParameter().apply(prepareMap(CLAN_ID_PARAM, Arrays.asList("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"))));
    }

    @Test
    public void validateInRatingParameterTest() {
        assertTrue(validateInRatingParameter().apply(prepareMap(IN_RATING_PARAM, 0)));
    }

    @Test
    public void validateInRatingParameterInvalidValueTest() {
        assertTrue(validateInRatingParameter().apply(prepareMap(IN_RATING_PARAM, 3)));
    }

    @Test
    public void validateStatusParameterTest() {
        assertTrue(validateStatusParameter().apply(prepareMap(STATUS_PARAM, "PLANNED")));
    }

    @Test
    public void validateStatusParameterInvalidValueTest() {
        assertFalse(validateStatusParameter().apply(prepareMap(STATUS_PARAM, "invalid")));
    }

    @Test
    public void validatePrimeHourParameterTest() {
        assertTrue(validatePrimeHourParameter().apply(prepareMap(PRIME_HOUR_PARAM, 20)));
    }

    @Test
    public void validatePrimeHourParameterInvalidValueTest() {
        assertFalse(validatePrimeHourParameter().apply(prepareMap(PRIME_HOUR_PARAM, 24)));
    }

    @Test
    public void validateOrderByParameterTest() {
        assertTrue(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "daily_revenue")));
    }

    @Test
    public void validateOrderByParameterInvalidValueTest() {
        assertFalse(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "invalid")));
    }

    @Test
    public void validateLandingTypeParameterTest() {
        assertTrue(validateLandingTypeParameter().apply(prepareMap(LANDING_TYPE_PARAM, "auction")));
    }

    @Test
    public void validateLandingTypeParameterInvalidValueTest() {
        assertFalse(validateLandingTypeParameter().apply(prepareMap(LANDING_TYPE_PARAM, "invalid")));
    }

}
