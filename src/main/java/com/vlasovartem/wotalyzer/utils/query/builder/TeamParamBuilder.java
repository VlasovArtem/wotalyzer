package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class TeamParamBuilder extends QueryParamBuilder {

    public static TeamParamBuilder newBuilder() {
        return new TeamParamBuilder();
    }

    private TeamParamBuilder() {
        super();
    }

    public TeamParamBuilder withTeamId(int teamId) {
        return (TeamParamBuilder) customParam(WOTAPIConstants.TEAM_ID, teamId);
    }

}
