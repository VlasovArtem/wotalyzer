package com.vlasovartem.wotalyzer.utils.validators.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class GlobalMapValidator {

    private static final Logger LOGGER = LogManager.getLogger(GlobalMapValidator.class);

    public static Function<Map<String, Object>, Boolean> validateFrontIdParameter () {
        return t -> {
            Object o = t.get(WOTAPIConstants.FRONT_ID_PARAM);
            if (Objects.nonNull(o)) {
                if (o instanceof List) {
                    List o1 = (List) o;
                    return o1.size() <= 10;
                }
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateVehicleLevelParameter () {
        return t -> {
            Object value = t.get(WOTAPIConstants.VEHICLE_LEVEL_PARAM);
            if (Objects.nonNull(value)) {
                List<String> validVehicleLevels = Arrays.asList("6", "8", "10");
                if (value instanceof String) {
                    return validVehicleLevels.contains(value);
                } else if (value instanceof List) {
                    List value1 = (List) value;
                    return value1.stream().allMatch(validVehicleLevels::contains);
                }
                return false;
            }
            return true;
        };
    }



}
