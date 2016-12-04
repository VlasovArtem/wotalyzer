package com.vlasovartem.wotalyzer.utils.wot.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.RegularTeam;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.RegularTeamConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.teams.TeamsParametersValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class RegularTeamUtils extends MainUtils<RegularTeam> {

    public List<RegularTeam> getRegularTeams() {
        return getApiResponseList("").getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<RegularTeam> getType() {
        return RegularTeam.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return RegularTeamConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RegularTeamConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RegularTeamConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(TeamsParametersValidator.validateOrderByParameter(), MainValidator.validateLimit(0, 100, 100));
    }

}
