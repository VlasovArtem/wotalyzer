package com.vlasovartem.wotalyzer.utils.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class MainValidator {

    private static final Logger LOGGER = LogManager.getLogger(MainValidator.class);

    public static int validateLimit(int limitValue, int defaultValue) {
        return validateLimit(limitValue, Integer.MIN_VALUE, Integer.MAX_VALUE, defaultValue);
    }

    public static int validateLimitWithMax(int limitValue, int max, int defaultValue) {
        return validateLimit(limitValue, Integer.MIN_VALUE, max, defaultValue);
    }

    public static int validateLimitWithMin(int limitValue, int min, int defaultValue) {
        return validateLimit(limitValue, min, Integer.MAX_VALUE, defaultValue);
    }

    public static int validateLimit(int limitValue, int min, int max, int defaultValue) {
        if(limitValue < min || limitValue > max) {
            LOGGER.warn("Parameter {} has incorrect value {}, possible value should be from {} to {}. Default value will be set: {}10", LIMIT_PARAM, limitValue, min, max, defaultValue);
            limitValue = defaultValue;
        }
        return limitValue;
    }

}
