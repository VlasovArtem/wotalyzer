package com.vlasovartem.wotalyzer.utils.validators;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class TestValidatorUtils {

    public static Map<String, Object> prepareMap(String parameterName, Object value) {
        Map<String, Object> values = new HashMap<>();
        values.put(parameterName, value);
        return values;
    }

}
