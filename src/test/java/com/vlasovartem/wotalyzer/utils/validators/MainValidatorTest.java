package com.vlasovartem.wotalyzer.utils.validators;

import org.junit.Test;

import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.IN_RATING_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.PAGE_NO_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.*;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 17/10/2016.
 */
public class MainValidatorTest {

    @Test
    public void validateLimitWithMaxTest() {
        int testValue = 9;
        Map<String, Object> objectMap = prepareMap(LIMIT_PARAM, testValue);
        validateLimitWithMax(10, 10).apply(objectMap);
        assertEquals(objectMap.get(LIMIT_PARAM), testValue);
    }

    @Test
    public void validateLimitWithMaxWithExceededValueTest() {
        int testValue = 11;
        int defaultValue = 10;
        Map<String, Object> objectMap = prepareMap(LIMIT_PARAM, testValue);
        validateLimitWithMax(10, defaultValue).apply(objectMap);
        assertEquals(objectMap.get(LIMIT_PARAM), defaultValue);
    }

    @Test
    public void validateLimitTest() {
        int testValue = 3;
        int minValue = 1;
        int maxValue = 10;
        int defaultValue = 10;
        Map<String, Object> objectMap = prepareMap(LIMIT_PARAM, testValue);
        validateLimit(minValue, maxValue, defaultValue).apply(objectMap);
        assertEquals(objectMap.get(LIMIT_PARAM), testValue);
    }

    @Test
    public void validateLimitWithExceededMaxValueTest() {
        int testValue = 11;
        int minValue = 1;
        int maxValue = 10;
        int defaultValue = 10;
        Map<String, Object> objectMap = prepareMap(LIMIT_PARAM, testValue);
        validateLimit(minValue, maxValue, defaultValue).apply(objectMap);
        assertEquals(objectMap.get(LIMIT_PARAM), defaultValue);
    }

    @Test
    public void validateLimitWithExceededMinValueTest() {
        int testValue = 0;
        int minValue = 1;
        int maxValue = 10;
        int defaultValue = 10;
        Map<String, Object> objectMap = prepareMap(LIMIT_PARAM, testValue);
        validateLimit(minValue, maxValue, defaultValue).apply(objectMap);
        assertEquals(objectMap.get(LIMIT_PARAM), defaultValue);
    }

    @Test
    public void validateIntParameterTest() {
        int testValue = 0;
        int minValue = 0;
        int maxValue = 5;
        int defaultValue = 3;
        Map<String, Object> objectMap = prepareMap(IN_RATING_PARAM, testValue);
        validateIntParameter(minValue, maxValue, defaultValue, IN_RATING_PARAM).apply(objectMap);
        assertEquals(objectMap.get(IN_RATING_PARAM), testValue);
    }

    @Test
    public void validateIntParameterInvalidValueTest() {
        int testValue = 10;
        int minValue = 0;
        int maxValue = 5;
        int defaultValue = 3;
        Map<String, Object> objectMap = prepareMap(IN_RATING_PARAM, testValue);
        validateIntParameter(minValue, maxValue, defaultValue, IN_RATING_PARAM).apply(objectMap);
        assertEquals(objectMap.get(IN_RATING_PARAM), defaultValue);
    }

    @Test
    public void validatePageNoParameterTest() {
        int testValue = 10;
        Map<String, Object> objectMap = prepareMap(PAGE_NO_PARAM, testValue);
        validatePageNoParameter().apply(objectMap);
        assertEquals(objectMap.get(PAGE_NO_PARAM), testValue);
    }

    @Test
    public void validatePageNoParameterInvalidValueTest() {
        int testValue = 0;
        int defaultValue = 1;
        Map<String, Object> objectMap = prepareMap(PAGE_NO_PARAM, testValue);
        validatePageNoParameter().apply(objectMap);
        assertEquals(objectMap.get(PAGE_NO_PARAM), defaultValue);
    }

}
