package com.vlasovartem.wotalyzer.utils.wot.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.RegularTeamInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.RegularTeamInfoConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.TeamParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class RegularTeamInfoUtils extends MainUtils<RegularTeamInfo> {

    public Optional<RegularTeamInfo> getRegularTeamInfo(@NotNull int teamId) {
        return convertMapToObject(getApiResponseMap(
                TeamParamBuilder.newBuilder()
                        .withTeamId(teamId)
                        .build()));
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return RegularTeamInfoConstants.getInstance();
    }

    @Override
    protected Class<RegularTeamInfo> getType() {
        return RegularTeamInfo.class;
    }
}
