package com.vlasovartem.wotalyzer.utils.validators.teams;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class TeamsParametersValidator {

    private static final Logger LOGGER = LogManager.getLogger(TeamsParametersValidator.class);
    private static List<String> orderPossibleValue = Arrays.asList("team_id", "-team_id", "name", "-name", "tag", "-tag", "members_count", "-members_count");

    public static boolean validateOrderParameter(String value) {
        boolean isOrderParameterValid = orderPossibleValue.contains(value.toLowerCase());
        if(!isOrderParameterValid) {
            LOGGER.warn("Parameter {} has invalid value {}. Possible values: {}", WOTAPIConstants.ORDER_BY_PARAM, value, orderPossibleValue.stream().collect(Collectors.joining(", ")));
        }
        return isOrderParameterValid;
    }

}
