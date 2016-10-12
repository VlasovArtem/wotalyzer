package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountRatingConstants.BATTLE_TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountRatingConstants.DATE_PARAM;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public abstract class RatingUtils<T> extends MainUtils<T> {

    private static final Logger LOGGER = LogManager.getLogger(RatingUtils.class);
    private List<String> battleTypes;

    RatingUtils(Class<T> type) {
        super(type);
        battleTypes = Arrays.asList("company", "random", "team", "default");
    }

    public List<String> getBattleTypes() {
        return battleTypes;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case BATTLE_TYPE_PARAM:
                        queryParams.replace(BATTLE_TYPE_PARAM, validateBattleType(entrySet));
                        break;
                }
            }
        }
        return false;
    }

    String validateBattleType(Map.Entry<String, Object> entrySet) {
        String convertedValue = (String) entrySet.getValue();
        boolean isBattleTypesValid = getBattleTypes().stream().anyMatch(convertedValue::equals);
        if(!isBattleTypesValid) {
            LOGGER.warn("Parameter {} has incorrect battle type. Default value will be set to 'default'", BATTLE_TYPE_PARAM);
            return "default";
        }
        return (String) entrySet.getValue();
    }

    String validateDate(Map.Entry<String, Object> entrySet) {
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
}
