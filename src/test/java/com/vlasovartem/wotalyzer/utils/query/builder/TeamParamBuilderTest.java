package com.vlasovartem.wotalyzer.utils.query.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TEAM_ID;
import static com.vlasovartem.wotalyzer.utils.query.builder.TeamParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class TeamParamBuilderTest {

    @Test
    public void withTeamIdTest() throws Exception {
        int teamId = 999;
        Map<String, Object> queryParams = newBuilder().withTeamId(teamId).build();
        Assert.assertEquals(teamId, queryParams.get(TEAM_ID));
    }
}
