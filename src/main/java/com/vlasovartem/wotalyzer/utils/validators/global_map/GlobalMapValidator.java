package com.vlasovartem.wotalyzer.utils.validators.global_map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateIntParameter;
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.*;

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
            Object value = t.get(FRONT_ID_PARAM);
            return validateListSize(value, FRONT_ID_PARAM);
        };
    }

    public static Function<Map<String, Object>, Boolean> validateVehicleLevelParameter() {
        return t -> {
            Object value = t.get(VEHICLE_LEVEL_PARAM);
            if (Objects.nonNull(value)) {
                List<String> validVehicleLevels = Arrays.asList("6", "8", "10");
                boolean isValid = false;
                if (value instanceof String) {
                    isValid = validVehicleLevels.contains(value);
                } else if (value instanceof List) {
                    List value1 = (List) value;
                    isValid = value1.stream().allMatch(validVehicleLevels::contains);
                } else {
                    LOGGER.warn("Parameter {} have incorrect value type {}", VEHICLE_LEVEL_PARAM, value.getClass().getSimpleName());
                }
                if (!isValid) {
                    logPossibleValuesWarning(LOGGER, VEHICLE_LEVEL_PARAM, value, validVehicleLevels.stream().collect(Collectors.joining(", ")));
                }
                return isValid;
            }
            return true;
        };
    }

    /**
     * Validate Clan ID parameter.
     * @return return false if parameter value is instance of {@link List} and size of the list is greater than 11
     */
    public static Function<Map<String, Object>, Boolean> validateClanIDParameter() {
        return t -> {
            Optional<Object> parameter = getParameter(t, CLAN_ID_PARAM);
            return validateListSize(parameter.orElse(null), CLAN_ID_PARAM);
        };
    }

    /**
     * Validate In Rating Parameter. If In Rating data is not between 0 and 1, than in rating will be replaces with default value 0
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validateInRatingParameter() {
        return t -> validateIntParameter(0, 1, 0, IN_RATING_PARAM).apply(t);
    }

    /**
     * Validate Status parameter.
     * @return true if parameter exists in list of statuses {@link GlobalMapValidator#statuses}, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validateStatusParameter() {
        return t -> {
            Optional<String> parameter = getParameter(t, STATUS_PARAM);
            return validateParameter(LOGGER, STATUS_PARAM, parameter.orElse(null), statuses);
        };
    }

    /**
     * Validate Prime Hour parameter
     * @return true if value between values 0 and 23, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validatePrimeHourParameter() {
        return t -> {
            Optional<Integer> parameter = getParameter(t, PRIME_HOUR_PARAM);
            return validateParameter(LOGGER,
                    "Possible values: {}",
                    PRIME_HOUR_PARAM,
                    parameter.orElse(null),
                    f -> !(f >= 0 && f <= 23),
                    "0 - 23");
        };
    }

    /**
     * Validate Order By parameter.
     * @return true if value is exists in {@link GlobalMapValidator#orders}, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validateOrderByParameter() {
        return t -> {
            Optional<String> parameter = getParameter(t, ORDER_BY_PARAM);
            return validateParameter(LOGGER, ORDER_BY_PARAM, parameter.orElse(null), orders);

        };
    }

    /**
     * Validate Landing type parameter
     * @return true if value is exists in {@link GlobalMapValidator#landingTypes}, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validateLandingTypeParameter() {
        return t -> {
            Optional<String> parameter = getParameter(t, LANDING_TYPE_PARAM);
            return validateParameter(LOGGER, LANDING_TYPE_PARAM, parameter.orElse(null), landingTypes);
        };
    }

    /**
     * Validate list size
     * @param value value
     * @param paramName parameter name
     * @return true if value is null or size of the list is less than or equals 10, other
     */
    private static boolean validateListSize (Object value, String paramName) {
        if (Objects.nonNull(value)) {
            if (value instanceof List) {
                List o1 = (List) value;
                boolean isValid = o1.size() <= 10;
                if (!isValid) {
                    LOGGER.warn("Parameter {} list value, should contains less than or equal 10 items", paramName);
                }
                return isValid;
            }
        }
        return true;
    }

}
