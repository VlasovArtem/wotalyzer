package com.vlasovartem.wotalyzer.utils.validators.encyclopedia;

import org.junit.Test;

import java.util.Collections;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EncyclopediaValidatorTest {

    @Test
    public void validateTypeParameterTest() {
        assertTrue(validateModulesTypeParameter().apply(prepareMap(TYPE_PARAM, "vehicleRadio")));
    }

    @Test
    public void validateTypeParameterInvalidValueTest() {
        assertFalse(validateModulesTypeParameter().apply(prepareMap(TYPE_PARAM, "invalid")));
    }

    @Test
    public void validateModuleIdParameterTest() {
        assertTrue(validateModuleIdParameter().apply(prepareMap(MODULE_ID_PARAM, 33)));
    }

    @Test
    public void validateModuleIdParameterInvalidValueTest() {
        assertFalse(validateModuleIdParameter().apply(prepareMap(MODULE_ID_PARAM, 150)));
    }

    @Test
    public void validateProvisionTypeParameterTest() {
        assertTrue(validateProvisionTypeParameter().apply(prepareMap(TYPE_PARAM, "equipment")));
    }

    @Test
    public void validateProvisionTypeParameterInvalidValueTest() {
        assertFalse(validateProvisionTypeParameter().apply(prepareMap(TYPE_PARAM, "invalid")));
    }

    @Test
    public void validateExtraParameterStringTest() {
        assertTrue(validateExtraParameter().apply(prepareMap(EXTRA_PARAM, "default_profile")));
    }

    @Test
    public void validateExtraParameterListTest() {
        assertTrue(validateExtraParameter().apply(prepareMap(EXTRA_PARAM, Collections.singletonList("default_profile"))));
    }

    @Test
    public void validateExtraParameterStringInvalidValueTest() {
        assertFalse(validateExtraParameter().apply(prepareMap(EXTRA_PARAM, "invalid")));
    }

    @Test
    public void validateExtraParameterListInvalidValueTest() {
        assertFalse(validateExtraParameter().apply(prepareMap(EXTRA_PARAM, Collections.singletonList("invalid"))));
    }

    @Test
    public void validateExtraParameterListInvalidTypeTest() {
        assertFalse(validateExtraParameter().apply(prepareMap(EXTRA_PARAM, 333)));
    }

    @Test
    public void validateOrderByParameterTest() {
        assertTrue(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "price_credit")));
    }

    @Test
    public void validateOrderByParameterInvalidValueTest() {
        assertFalse(validateOrderByParameter().apply(prepareMap(ORDER_BY_PARAM, "invalid")));
    }

    @Test
    public void validateVehiclesTypeParameterTest() {
        assertTrue(validateVehiclesTypeParameter().apply(prepareMap(TYPE_PARAM, "heavyTank")));
    }

    @Test
    public void validateVehiclesTypeParameterInvalidValueTest() {
        assertFalse(validateVehiclesTypeParameter().apply(prepareMap(TYPE_PARAM, "invalid")));
    }

}
