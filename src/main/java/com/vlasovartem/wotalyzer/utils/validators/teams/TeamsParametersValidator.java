package com.vlasovartem.wotalyzer.utils.validators.teams;

import com.vlasovartem.wotalyzer.utils.validators.ValidatorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ORDER_BY_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class TeamsParametersValidator {

    private static final Logger LOGGER = LogManager.getLogger(TeamsParametersValidator.class);
    private static List<String> orderByPossibleValues = Arrays.asList("team_id", "-team_id", "name", "-name", "tag", "-tag", "members_count", "-members_count");

    /**
     * Validate Order by parameter
     * @return true if value exist in list {@link TeamsParametersValidator#orderByPossibleValues}, otherwise false
     */
    public static Function<Map<String, Object>, Boolean> validateOrderByParameter() {
        return t -> {
            Optional<String> parameter = ValidatorUtils.getParameter(t, ORDER_BY_PARAM);
            return ValidatorUtils.validateParameter(LOGGER, ORDER_BY_PARAM, parameter.orElse(null), orderByPossibleValues);
        };
    }

}
