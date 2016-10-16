package com.vlasovartem.wotalyzer.utils.validators.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.junit.Test;

import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.SEARCH_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator.*;
import static org.junit.Assert.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class AccountValidatorTest {

    @Test
    public void validateSearchParameterTest() {
        assertTrue(validateSearchParameter().apply(prepareMap(SEARCH_PARAM, "test value")));
    }

    @Test
    public void validateSearchParameterWithInvalidValueTest() {
        assertFalse(validateSearchParameter().apply(prepareMap(SEARCH_PARAM, "test value dfsadfasdfasdfasdfasd")));
    }

    @Test
    public void validateTypeParameterExactTest() {
        Map<String, Object> objectMap = prepareMap(TYPE_PARAM, "exact");
        objectMap.put(SEARCH_PARAM, "test");
        assertTrue(validateTypeParameter().apply(objectMap));
    }

    @Test
    public void validateTypeParameterStartwithTest() {
        Map<String, Object> objectMap = prepareMap(TYPE_PARAM, "startwith");
        objectMap.put(SEARCH_PARAM, "test");
        assertTrue(validateTypeParameter().apply(objectMap));
    }

    @Test
    public void validateTypeParameterInvalidParameterTest() {
        assertFalse(validateTypeParameter().apply(prepareMap(TYPE_PARAM, "invalid")));
    }

    @Test
    public void validateTypeParameterDefaultTest() {
        Map<String, Object> objectMap = prepareMap(TYPE_PARAM, "invalid");
        objectMap.put(SEARCH_PARAM, "test");
        validateTypeParameter().apply(objectMap);
        assertEquals(objectMap.get(TYPE_PARAM), "startwith");
    }

    @Test
    public void validateTypeParameterExactWithInvalidSearchValueLengthTest() {
        Map<String, Object> objectMap = prepareMap(TYPE_PARAM, "exact");
        objectMap.put(SEARCH_PARAM, "");
        assertFalse(validateTypeParameter().apply(objectMap));
    }

    @Test
    public void validateTypeParameterStartwithWithInvalidSearchValueLengthTest() {
        Map<String, Object> objectMap = prepareMap(TYPE_PARAM, "startwith");
        objectMap.put(SEARCH_PARAM, "ta");
        assertFalse(validateTypeParameter().apply(objectMap));
    }

    @Test
    public void validateExtraParameterTest() {
        assertTrue(validateExtraParameter().apply(prepareMap(WOTAPIConstants.EXTRA_PARAM, "private.boosters")));
    }

    @Test
    public void validateExtraParameterInvalidValueTest() {
        assertFalse(validateExtraParameter().apply(prepareMap(WOTAPIConstants.EXTRA_PARAM, "invalid")));
    }

}
