package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class TeamParamBuilder extends QueryParamBuilder {

    public static TeamParamBuilder newBuilder() {
        if (Objects.isNull(builder)) {
            builder = new TeamParamBuilder();
        }
        return (TeamParamBuilder) builder;
    }

    private TeamParamBuilder() {
        super();
    }

    public TeamParamBuilder withTeamId(int teamId) {
        return (TeamParamBuilder) customParam(WOTAPIConstants.TEAM_ID, teamId);
    }

}
