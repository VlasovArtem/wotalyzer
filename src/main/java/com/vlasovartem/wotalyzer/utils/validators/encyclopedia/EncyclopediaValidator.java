package com.vlasovartem.wotalyzer.utils.validators.encyclopedia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.*;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class EncyclopediaValidator {

    private static final Logger LOGGER = LogManager.getLogger(EncyclopediaValidator.class);
    private static List<String> moduleTypes = Arrays.asList("vehicleRadio", "vehicleEngine", "vehicleGun", "vehicleChassis", "vehicleTurret");
    private static List<String> provisionTypes = Arrays.asList("equipment", "optionalDevice");
    private static List<String> vehiclesTypes = Arrays.asList("heavyTank", "AT-SPG", "mediumTank", "lightTank", "SPG");

    public static Function<Map<String, Object>, Boolean> validateModulesTypeParameter() {
        return t -> validateTypeParameter(moduleTypes).apply(t);
    }

    public static Function<Map<String, Object>, Boolean> validateModuleIdParameter() {
        return t -> {
            Optional<Integer> parameter = getParameter(t, MODULE_ID_PARAM);
            if (parameter.isPresent() && !(parameter.get() > 0 && parameter.get() <= 100)) {
                logPossibleValuesWarning(LOGGER, MODULE_ID_PARAM, parameter.get(), "1 - 100");
                return false;
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateProvisionTypeParameter () {
        return t -> validateTypeParameter(provisionTypes).apply(t);
    }

    public static Function<Map<String, Object>, Boolean> validateExtraParameter () {
        return t -> {
            String possibleValue = "default_profile";
            Optional<Object> parameter = getParameter(t, EXTRA_PARAM);
            if (parameter.isPresent()) {
                boolean isValid = false;
                if (parameter.get() instanceof String) {
                    isValid = parameter.map(o -> (String) o).get().equalsIgnoreCase(possibleValue);
                } else if (parameter.get() instanceof List) {
                    isValid = parameter.map(o -> (List) o).get().contains(possibleValue);
                } else {
                    LOGGER.warn("Parameter {} have incorrect value type {}. Possible types: String, List", EXTRA_PARAM, parameter.get().getClass().getSimpleName());
                }
                if (!isValid) {
                    logPossibleValuesWarning(LOGGER, EXTRA_PARAM, parameter.get(), possibleValue);
                }
                return isValid;

            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateOrderByParameter () {
        return t -> {
            Optional<String> parameter = getParameter(t, ORDER_BY_PARAM);
            return validateParameter(LOGGER, ORDER_BY_PARAM, parameter.orElse(null), "price_credit", "-price_credit");
        };
    }

    public static Function<Map<String, Object>, Boolean> validateVehiclesTypeParameter () {
        return t -> validateTypeParameter(vehiclesTypes).apply(t);
    }

    private static Function<Map<String, Object>, Boolean> validateTypeParameter(List<String> types) {
        return t -> {
            Optional<String> parameter = getParameter(t, TYPE_PARAM);
            return validateParameter(LOGGER, ORDER_BY_PARAM, parameter.orElse(null), types);
        };
    }

}
