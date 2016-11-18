package com.vlasovartem.wotalyzer.utils.uri.wot.api.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.RegularTeamsList;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.RegularTeamsListConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.teams.TeamsParametersValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class RegularTeamsListUtils extends MainUtils<RegularTeamsList> {

    @Override
    protected Class getType() {
        return RegularTeamsList.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return RegularTeamsListConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RegularTeamsListConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RegularTeamsListConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(TeamsParametersValidator.validateOrderByParameter(), MainValidator.validateLimit(0, 100, 100));
    }

}
