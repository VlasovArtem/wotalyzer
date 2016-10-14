package com.vlasovartem.wotalyzer.utils.validators.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountValidator {

    private static final Logger LOGGER = LogManager.getLogger(AccountValidator.class);

    public static boolean validateSearchParameter (String value) {
        int searchValueLength = value.length();
        if (searchValueLength > 24) {
            LOGGER.warn("Search parameter length could not be greater, than 24 symbols");
            return false;
        }
        return true;
    }

    public static boolean validateTypeParameter (Map<String, Object> queryParams) {
        List<String> possibleTypeValues = Arrays.asList("exact", "startswith");
        String typeValue = (String) queryParams.get(WOTAPIConstants.TYPE_PARAM);
        if (Objects.nonNull(typeValue) && possibleTypeValues.contains(typeValue)) {
            switch (typeValue) {
                case "exact":
                    return ((String) queryParams.get(WOTAPIConstants.SEARCH_PARAM)).length() > 0;
                case "startwith":
                    return ((String) queryParams.get(WOTAPIConstants.SEARCH_PARAM)).length() > 2;
            }
        }
        return false;
    }

    public static boolean validateExtraParameter (String value) {
        List<String> possibleExtraValues = Arrays.asList("private.boosters", "private.garage", "private.grouped_contacts", "private.personal_missions", "private.rented", "statistics.fallout", "statistics.globalmap_absolute", "statistics.globalmap_champion", "statistics.globalmap_middle", "statistics.random");
        if(!possibleExtraValues.contains(value)) {
            LOGGER.warn("Parameter '{}' have invalid value {}. Possible value is: {}", WOTAPIConstants.EXTRA_PARAM, value, possibleExtraValues.stream().collect(Collectors.joining(", ")));
            return false;
        }
        return true;
    }

}
