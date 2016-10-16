package com.vlasovartem.wotalyzer.utils.validators;

import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ValidatorUtils {

    private Logger logger;
    private static String initialLoggerPattern = "Parameter {} have incorrect value '{}'.";

    public ValidatorUtils(Logger logger) {
        this.logger = logger;
    }

    public boolean validateParameter (String paramName, String parameter, List<String> possibleValueList) {
        return validateParameter(logger, paramName, parameter, possibleValueList);
    }

    /**
     * Get Parameter from query params map by parameter name and cast to the required type
     * @param queryParams Query parameters
     * @param paramName Parameter name
     * @param <T> returned value type
     * @return Optional
     */
    public static <T> Optional<T> getParameter (Map<String, Object> queryParams, String paramName) {
        return Optional.ofNullable((T) queryParams.get(paramName));
    }

    public static void logTypeWarning(Logger logger, String invalidValue, List<String> possibleValueList) {
        logPossibleValuesWarning(logger, TYPE_PARAM, invalidValue, possibleValueList.stream().collect(Collectors.joining(", ")));
    }

    public static void logPossibleValuesWarning(Logger logger, String paramName, Object invalidValue, String possibleValueList) {
        logWarning(logger, " Possible values: {}", paramName, invalidValue, false, possibleValueList);
    }

    public static void logWarning(Logger logger, String loggerPattern, String paramName, Object invalidValue, boolean customPattern, String... additionalValues) {
        String generatedValue = loggerPattern;
        if (!customPattern) {
            generatedValue = initialLoggerPattern + " " + loggerPattern;
        }
        logger.warn(generatedValue, paramName, invalidValue, additionalValues);
    }

    public static boolean validateParameter(Logger logger, String paramName, String parameter, List<String> possibleValueList) {
        if(Objects.nonNull(parameter) && !possibleValueList.contains(parameter)) {
            logPossibleValuesWarning(logger, paramName, parameter, possibleValueList.stream().collect(Collectors.joining(", ")));
            return false;
        }
        return true;
    }

    public static boolean validateParameter(Logger logger, String paramName, String parameter, String... possibleValues) {
        return validateParameter(logger, paramName, parameter, Arrays.asList(possibleValues));
    }

    public static <T> boolean validateParameter(Logger logger, String loggerPattern, String paramName, T parameter, Function<T, Boolean> validationFunction, String... additionalValues) {
        if(Objects.nonNull(parameter) && !validationFunction.apply(parameter)) {
            logWarning(logger, loggerPattern, paramName, parameter, false, additionalValues);
            return false;
        }
        return true;
    }

    /**
     * Truncate date to the second and format it to {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME}
     * @param date date
     * @return String value converted to the described above format
     */
    public static String prepareDate(LocalDateTime date) {
        return date.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

}
