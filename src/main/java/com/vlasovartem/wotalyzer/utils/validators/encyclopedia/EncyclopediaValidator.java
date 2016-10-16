package com.vlasovartem.wotalyzer.utils.validators.encyclopedia;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.getParameter;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class EncyclopediaValidator {

    private static List<String> types = Arrays.asList("vehicleRadio", "vehicleEngine", "vehicleGun", "vehicleChassis", "vehicleTurret");
    private static List<String> provisionTypes = Arrays.asList("equipment", "optionalDevice");
    private static List<String> vehiclesTypes = Arrays.asList("heavyTank", "AT-SPG", "mediumTank", "lightTank", "SPG");

    public static Function<Map<String, Object>, Boolean> validateTypeParameter() {
        return t -> {
            Optional<String> parameter = getParameter(t, TYPE_PARAM);
            return types.contains(parameter.get());
        };
    }

    public static Function<Map<String, Object>, Boolean> validateModuleIdParameter() {
        return t -> {
            Optional<Integer> parameter = getParameter(t, MODULE_ID_PARAM);
            return !parameter.isPresent() || parameter.get() > 0 && parameter.get() <= 100;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateProvisionTypeParameter () {
        return t -> {
            Optional<String> parameter = getParameter(t, TYPE_PARAM);
            return provisionTypes.contains(parameter.get());
        };
    }

    public static Function<Map<String, Object>, Boolean> validateExtraParameter () {
        return t -> {
            String possibleValue = "default_profile";
            Optional<Object> parameter = getParameter(t, EXTRA_PARAM);
            if (parameter.get() instanceof String) {
                return parameter.map(o -> (String) o).get().equalsIgnoreCase(possibleValue);
            } else if (parameter.get() instanceof List) {
                return parameter.map(o -> (List) o).get().contains(possibleValue);
            }
            return false;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateOrderByParameter () {
        return t -> {
            List<String> orderValues = Arrays.asList("price_credit", "-price_credit");
            Optional<String> parameter = getParameter(t, ORDER_BY_PARAM);
            return orderValues.contains(parameter.get());
        };
    }

    public static Function<Map<String, Object>, Boolean> validateVehiclesTypeParameter () {
        return t -> {
            Optional<String> value = getParameter(t, TYPE_PARAM);
            return vehiclesTypes.contains(value.get());
        };
    }

}
