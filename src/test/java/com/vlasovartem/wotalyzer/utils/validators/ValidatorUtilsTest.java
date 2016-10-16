package com.vlasovartem.wotalyzer.utils.validators;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.SEARCH_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.TestValidatorUtils.prepareMap;
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.getParameter;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 17/10/2016.
 */
public class ValidatorUtilsTest {

    @Test
    public void getParameterTest() {
        Map<String, Object> objectMap = prepareMap(SEARCH_PARAM, "Test");
        Optional<String> parameter = getParameter(objectMap, SEARCH_PARAM);
        assertTrue(parameter.get().getClass().equals(String.class));
    }

}
