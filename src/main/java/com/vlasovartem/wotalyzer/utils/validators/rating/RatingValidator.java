package com.vlasovartem.wotalyzer.utils.validators.rating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class RatingValidator {

    private static final Logger LOGGER = LogManager.getLogger(RatingValidator.class);

    public static String validateBattleType(Map.Entry<String, Object> entrySet, List<String> battleTypes) {
        String convertedValue = (String) entrySet.getValue();
        boolean isBattleTypesValid = battleTypes.stream().anyMatch(convertedValue::equals);
        if(!isBattleTypesValid) {
            LOGGER.warn("Parameter {} has incorrect battle type. Default value will be set to 'default'", BATTLE_TYPE_PARAM);
            return "default";
        }
        return (String) entrySet.getValue();
    }

    public static String validateDate(Map.Entry<String, Object> entrySet) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String preparedDate = LocalDateTime.now().minusDays(1).format(dateTimeFormatter);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = null;
        if(entrySet.getValue() instanceof LocalDateTime) {
            date = (LocalDateTime) entrySet.getValue();
        } else if (entrySet.getValue() instanceof String) {
            date = LocalDateTime.parse((CharSequence) entrySet.getValue());
        } else {
            LOGGER.warn("Parameter {} have incorrect type {}, required field type is String and LocalDateTime. Default value will be set: yesterday {}", DATE_PARAM, entrySet.getKey().getClass().toString(), preparedDate);
        }
        if (Objects.nonNull(date)) {
            Duration between = Duration.between(date, now);
            if(between.toDays() > 7 && between.toDays() < 0) {
                LOGGER.warn("Parameter {} could not have date that less than 7 days before now. Default value will be set: yesterday date {}", DATE_PARAM, preparedDate);
            } else {
                preparedDate = date.format(dateTimeFormatter);
            }
        }
        return preparedDate;
    }

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
