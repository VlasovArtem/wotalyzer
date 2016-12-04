package com.vlasovartem.wotalyzer.utils.wot.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.RegularTeamInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.RegularTeamInfoConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.TeamParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class RegularTeamInfoUtils extends MainUtils<RegularTeamInfo> {

    public Optional<RegularTeamInfo> getRegularTeamInfo(@NotNull int teamId) {
        return convertMapToObject(getApiResponseMap(
                newBuilder()
                        .withTeamId(teamId)
                        .build()));
    }

    @Override
    public String getAPIBaseUrl() {
        return RegularTeamInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RegularTeamInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RegularTeamInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    protected Class<RegularTeamInfo> getType() {
        return RegularTeamInfo.class;
    }
}
