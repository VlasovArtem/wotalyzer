package com.vlasovartem.wotalyzer.utils.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class MainValidator {

    private static final Logger LOGGER = LogManager.getLogger(MainValidator.class);

    public static Function<Map<String, Object>, Boolean> validateLimitWithMax(int max, int defaultValue) {
        return t -> {
            validateLimit(Integer.MIN_VALUE, max, defaultValue);
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateLimitWithMin(int min, int defaultValue) {
        return t -> {
            validateLimit(min, Integer.MAX_VALUE, defaultValue);
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateLimit (int defaultValue) {
        return t -> {
            validateLimit(Integer.MIN_VALUE, Integer.MAX_VALUE, defaultValue);
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateLimit (int min, int max, int defaultValue) {
        return t -> {
            validateIntParameter(min, max, defaultValue, LIMIT_PARAM);
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateIntParameter (int min, int max, int defaultValue, String paramName) {
        return t -> {
            Object data = t.get(paramName);
            if (Objects.nonNull(data)) {
                int limitValue = (Integer) data;
                if(limitValue < min || limitValue > max) {
                    LOGGER.warn("Parameter {} has incorrect value {}, possible value should be from {} to {}. Default value will be set: {}10", paramName, limitValue, min, max, defaultValue);
                    limitValue = defaultValue;
                }
                t.replace(paramName, limitValue);
            }
            return true;
        };
    }

}
