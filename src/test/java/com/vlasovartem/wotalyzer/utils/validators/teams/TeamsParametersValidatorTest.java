package com.vlasovartem.wotalyzer.utils.validators.teams;

import org.junit.Test;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ORDER_BY_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.teams.TeamsParametersValidator.validateOrderByParameter;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 17/10/2016.
 */
public class TeamsParametersValidatorTest {

    @Test
    public void validateOrderByParameterTest() {
        assertTrue(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "team_id")));
    }

    @Test
    public void validateOrderByParameterInvalidValueTest() {
        assertFalse(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "invalid")));
    }

}
