package com.vlasovartem.wotalyzer.utils.validators.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class GlobalMapValidator {

    private static final Logger LOGGER = LogManager.getLogger(GlobalMapValidator.class);
    private static List<String> statuses = Arrays.asList("PLANNED", "ACTIVE", "FINISHED");
    private static List<String> orders = Arrays.asList("daily_revenue", "-daily_revenue", "province_id", "-province_id", "prime_hour", "-prime_hour");
    private static List<String> landingTypes = Arrays.asList("null", "auction", "tournament");

    public static Function<Map<String, Object>, Boolean> validateFrontIdParameter() {
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

    public static Function<Map<String, Object>, Boolean> validateVehicleLevelParameter() {
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

    public static Function<Map<String, Object>, Boolean> validateClanIDParameter() {
        return t -> {
            Object value = t.get(WOTAPIConstants.CLAN_ID_PARAM);
            return !(Objects.nonNull(value) && value instanceof List) || ((List) value).size() <= 10;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateInRatingParameter() {
        return t -> {
            MainValidator.validateIntParameter(0, 1, 0, WOTAPIConstants.IN_RATING_PARAM);
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateStatusParameter() {
        return t -> {
            Optional<String> parameter = ValidatorUtils.getParameter(t, WOTAPIConstants.STATUS_PARAM);
            return !parameter.isPresent() || statuses.contains(parameter.get());
        };
    }

    public static Function<Map<String, Object>, Boolean> validatePrimeHourParameter() {
        return t -> {
            Optional<Integer> parameter = ValidatorUtils.getParameter(t, WOTAPIConstants.PRIME_HOUR_PARAM);
            return !parameter.isPresent() || (parameter.get() >= 0 && parameter.get() <= 23);
        };
    }

    public static Function<Map<String, Object>, Boolean> validateOrderByParameter() {
        return t -> {
            Optional<String> parameter = ValidatorUtils.getParameter(t, WOTAPIConstants.ORDER_BY_PARAM);
            return !parameter.isPresent() || orders.contains(parameter.get().toLowerCase());
        };
    }

    public static Function<Map<String, Object>, Boolean> validateLandingTypeParameter() {
        return t -> {
            Optional<String> parameter = ValidatorUtils.getParameter(t, WOTAPIConstants.LANDING_TYPE_PARAM);
            return !parameter.isPresent() || landingTypes.contains(parameter.get().toLowerCase());
        };
    }

}
