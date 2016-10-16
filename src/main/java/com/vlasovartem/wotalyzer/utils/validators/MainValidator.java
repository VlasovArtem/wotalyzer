package com.vlasovartem.wotalyzer.utils.validators;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.PAGE_NO_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class MainValidator {

    private static final Logger LOGGER = LogManager.getLogger(MainValidator.class);

    /**
     * Validate limit with max value and set default value. Provided query params for the {@link WOTAPIConstants#LIMIT_PARAM} with be replaced with default value
     * @param max max value
     * @param defaultValue default value
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validateLimitWithMax(int max, int defaultValue) {
        return t -> validateLimit(Integer.MIN_VALUE, max, defaultValue).apply(t);
    }

    /**
     * Validate limit parameter with min and max value. If value is exceeded or not, default value will be set
     * @param min Min value
     * @param max Max value
     * @param defaultValue default value
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validateLimit (int min, int max, int defaultValue) {
        return t -> validateIntParameter(min, max, defaultValue, LIMIT_PARAM).apply(t);
    }

    /**
     * Validate parameter which should not exceed min and max value. If not default value will be set.
     * @param min min value
     * @param max max value
     * @param defaultValue default value
     * @param paramName parameter name
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validateIntParameter (int min, int max, int defaultValue, String paramName) {
        return t -> {
            Object data = t.get(paramName);
            if (Objects.nonNull(data)) {
                int limitValue = (Integer) data;
                if(limitValue < min || limitValue > max) {
                    LOGGER.warn("Parameter {} has incorrect value {}, possible value should be from {} to {}. Default value will be set: {}", paramName, limitValue, min, max, defaultValue);
                    limitValue = defaultValue;
                }
                t.replace(paramName, limitValue);
            }
            return true;
        };
    }

    /**
     * Validate Page No parameter. If min value will be set to less than 1 and set default value to 1
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validatePageNoParameter () {
        return t -> {
            Object value = t.get(WOTAPIConstants.PAGE_NO_PARAM);
            if (Objects.nonNull(value)) {
                validateIntParameter( 1, Integer.MAX_VALUE, 1, PAGE_NO_PARAM).apply(t);
            }
            return true;
        };
    }

}
