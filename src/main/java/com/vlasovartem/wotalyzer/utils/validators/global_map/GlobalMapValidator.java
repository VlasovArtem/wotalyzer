package com.vlasovartem.wotalyzer.utils.validators.global_map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class GlobalMapValidator {

    private static final Logger LOGGER = LogManager.getLogger(GlobalMapValidator.class);

    public static boolean validateFrontIdParameter (Object value) {
        return !(value instanceof List) || ((List) value).size() >= 10;
    }

    public static boolean validateVehicleLevelParameter (Object value) {
        List<String> validVehicleLevels = Arrays.asList("6", "8", "10");
        if (value instanceof String) {
            return validVehicleLevels.contains(value);
        } else if (value instanceof List) {
            List value1 = (List) value;
            return value1.stream().allMatch(validVehicleLevels::contains);
        }
        return false;
    }

}
