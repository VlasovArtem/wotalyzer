package com.vlasovartem.wotalyzer.utils.validators.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class DataValidator {

    public static Function<Map<String, Object>, Boolean> validateType () {
        return t -> {
            Object value = t.get(WOTAPIConstants.TYPE_PARAM);
            if (Objects.nonNull(value)) {
                List<String> types = Arrays.asList("vehicleRadio", "vehicleEngine", "vehicleGun", "vehicleChassis", "vehicleTurret");
                return types.stream().anyMatch(s -> s.equalsIgnoreCase(String.valueOf(value)));
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateModuleId () {
        return t -> {
            Object value = t.get(WOTAPIConstants.MODULE_ID_PARAM);
            if (Objects.nonNull(value)) {
                if (value instanceof Integer) {
                    Integer value1 = (Integer) value;
                    return value1 > 0 && value1 <= 100;
                }
                return false;
            }
            return true;
        };
    }

}
