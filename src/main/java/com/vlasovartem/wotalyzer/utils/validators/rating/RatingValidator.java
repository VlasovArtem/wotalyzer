package com.vlasovartem.wotalyzer.utils.validators.rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.BATTLE_TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.DATE_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class RatingValidator {

    private static final Logger LOGGER = LogManager.getLogger(RatingValidator.class);

    public static Function<Map<String, Object>, Boolean> validateBattleType() {
        return t -> {
            Object value = t.get(WOTAPIConstants.BATTLE_TYPE_PARAM);
            if (Objects.nonNull(value)) {
                List<String> battleTypes = Arrays.asList("company", "random", "team", "default");
                String convertedValue = (String) value;
                boolean isBattleTypesValid = battleTypes.stream().anyMatch(convertedValue::equals);
                if (!isBattleTypesValid) {
                    LOGGER.warn("Parameter {} has incorrect battle type. Default value will be set to 'default'", BATTLE_TYPE_PARAM);
                    convertedValue = "default";
                }
                t.replace(WOTAPIConstants.BATTLE_TYPE_PARAM, convertedValue);
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateDate() {
        return t -> {
            Object value = t.get(WOTAPIConstants.DATE_PARAM);
            if (Objects.nonNull(value)) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                String preparedDate = LocalDateTime.now().minusDays(1).format(dateTimeFormatter);
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime date = null;
                if (value instanceof LocalDateTime) {
                    date = (LocalDateTime) value;
                } else if (value instanceof String) {
                    date = LocalDateTime.parse((CharSequence) value);
                } else {
                    LOGGER.warn("Parameter {} have incorrect type {}, required field type is String and LocalDateTime. Default value will be set: yesterday {}", DATE_PARAM, value.getClass().toString(), preparedDate);
                }
                if (Objects.nonNull(date)) {
                    Duration between = Duration.between(date, now);
                    if (between.toDays() > 7 && between.toDays() < 0) {
                        LOGGER.warn("Parameter {} could not have date that less than 7 days before now. Default value will be set: yesterday date {}", DATE_PARAM, preparedDate);
                    } else {
                        preparedDate = date.format(dateTimeFormatter);
                    }
                }
                t.replace(WOTAPIConstants.DATE_PARAM, preparedDate);
            }
            return true;
        };
    }

}
