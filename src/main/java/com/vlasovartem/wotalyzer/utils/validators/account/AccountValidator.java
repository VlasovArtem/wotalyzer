package com.vlasovartem.wotalyzer.utils.validators.account;

import com.vlasovartem.wotalyzer.entity.wot.api.WotApiError;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import com.vlasovartem.wotalyzer.utils.api.contstans.enums.NameTypeParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountValidator {

    private static final Logger LOGGER = LogManager.getLogger(AccountValidator.class);

    /**
     * Validate value of the search parameter.
     * @return return true if value less than 24 symbols, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validateSearchParameter() {
        return t -> {
            String searchParam = (String) t.get(SEARCH_PARAM);
            String typeParam = (String) t.get(TYPE_PARAM);
            String errorMessage = "";
            int errorCode = 0;
            if (Objects.isNull(searchParam) || searchParam.isEmpty()) {
                errorMessage = "Search parameter could not be empty";
                errorCode = 402;
            } else if (((Objects.isNull(typeParam) || typeParam.isEmpty() || NameTypeParameter.START_WITH.getValue().equals(typeParam)) && searchParam.length() < 3)) {
                errorMessage = "Search parameter minimal length with type 'start_with' should be 3 symbols";
                errorCode = 407;
            } else if (NameTypeParameter.EXACT.getValue().equals(typeParam) && searchParam.isEmpty()) {
                errorMessage = "Search parameter minimal length with type 'exact' should be 1 symbol";
                errorCode = 407;
            } else if (searchParam.length() > 24) {
                errorMessage = "Search parameter length could not be greater, than 24 symbols";
                errorCode = 407;
            }
            if (!errorMessage.isEmpty()) {
                WotApiError error = new WotApiError();
                error.getError().setMessage(errorMessage);
                error.getError().setCode(errorCode);
                LOGGER.warn(errorMessage);
                throw new WotAPIValidationException(error);
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateExtraParameter() {
        return t -> {
            String value = (String) t.get(EXTRA_PARAM);
            if (Objects.nonNull(value)) {
                List<String> possibleExtraValues = Arrays.asList("private.boosters", "private.garage", "private.grouped_contacts", "private.personal_missions", "private.rented", "statistics.fallout", "statistics.globalmap_absolute", "statistics.globalmap_champion", "statistics.globalmap_middle", "statistics.random");
                if (!possibleExtraValues.contains(value)) {
                    String errorMessage = String.format("Parameter '%s' have invalid value '%s' Possible values are: %s",
                            EXTRA_PARAM,
                            value,
                            possibleExtraValues.stream().collect(Collectors.joining(", ")));
                    LOGGER.warn(errorMessage);
                    throw new WotAPIValidationException(errorMessage);
                }
            }
            return true;
        };
    }

}
