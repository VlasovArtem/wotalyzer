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
import static com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils.prepareDate;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class RatingValidator {

    private static final Logger LOGGER = LogManager.getLogger(RatingValidator.class);
    private static List<String> battleTypes = Arrays.asList("company", "random", "team", "default");

    /**
     * Validate Battle Type parameter.
     * @return always true. If parameter have incorrect value, than default value will be set.
     */
    public static Function<Map<String, Object>, Boolean> validateBattleType() {
        return t -> {
            Object value = t.get(WOTAPIConstants.BATTLE_TYPE_PARAM);
            boolean isValid = Objects.isNull(value) || battleTypes.contains(value);
            if(!isValid) {
                LOGGER.warn("Parameter {} has incorrect battle type. Default value will be set to 'default'", BATTLE_TYPE_PARAM);
                t.replace(WOTAPIConstants.BATTLE_TYPE_PARAM, "default");
            }
            return true;
        };
    }

    /**
     * Validate Date parameter. If parameter value is not type of {@link LocalDateTime} or {@link String}, than the default value will be set = yesterday. Also value will be set to yesterday if date less than 7 days. Prepared date will be converted to {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} and set as parameter value
     * @return true
     */
    public static Function<Map<String, Object>, Boolean> validateDate() {
        return t -> {
            Object value = t.get(WOTAPIConstants.DATE_PARAM);
            if (Objects.nonNull(value)) {
                String preparedDate = prepareDate(LocalDateTime.now().minusDays(1));
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
                    if (between.toDays() < 0 || between.toDays() > 7) {
                        LOGGER.warn("Parameter {} could not have date that less than 7 days before now. Default value will be set: yesterday date {}", DATE_PARAM, preparedDate);
                    } else {
                        preparedDate = prepareDate(date);
                    }
                }
                t.replace(WOTAPIConstants.DATE_PARAM, preparedDate);
            }
            return true;
        };
    }

}
