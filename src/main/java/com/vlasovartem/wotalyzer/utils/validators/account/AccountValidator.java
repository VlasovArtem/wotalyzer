package com.vlasovartem.wotalyzer.utils.validators.account;

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
            Object value = t.get(SEARCH_PARAM);
            if (Objects.nonNull(value)) {
                int searchValueLength = ((String) value).length();
                if (searchValueLength > 24) {
                    LOGGER.warn("Search parameter length could not be greater, than 24 symbols");
                    return false;
                }
            }
            return true;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateTypeParameter() {
        return t -> {
            boolean isValid = false;
            List<String> possibleTypeValues = Arrays.asList("exact", "startswith");
            String typeValue = (String) t.get(TYPE_PARAM);
            String searchValue = (String) t.get(SEARCH_PARAM);
            if (Objects.nonNull(typeValue) && possibleTypeValues.contains(typeValue) && Objects.nonNull(searchValue)) {
                switch (typeValue) {
                    case "exact":
                        isValid = searchValue.length() > 0;
                        break;
                    case "startwith":
                        isValid = searchValue.length() > 2;
                        break;
                }
            }
            if (!isValid && Objects.nonNull(searchValue) && searchValue.length() > 2) {
                t.replace(TYPE_PARAM, "startwith");
                return true;
            }
            return isValid;
        };
    }

    public static Function<Map<String, Object>, Boolean> validateExtraParameter() {
        return t -> {
            Object value = t.get(EXTRA_PARAM);
            if (Objects.nonNull(value)) {
                List<String> possibleExtraValues = Arrays.asList("private.boosters", "private.garage", "private.grouped_contacts", "private.personal_missions", "private.rented", "statistics.fallout", "statistics.globalmap_absolute", "statistics.globalmap_champion", "statistics.globalmap_middle", "statistics.random");
                if (!possibleExtraValues.contains(value)) {
                    LOGGER.warn("Parameter '{}' have invalid value '{}'. Possible values: {}", EXTRA_PARAM, value, possibleExtraValues.stream().collect(Collectors.joining(", ")));
                    return false;
                }
            }
            return true;
        };
    }

}
