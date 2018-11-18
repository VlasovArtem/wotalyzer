package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerAchievement;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerAchievementConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.QueryParamExtBuilder;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayerAchievementUtils extends MainUtils<PlayerAchievement> {

    public Optional<PlayerAchievement> getPlayerAchievements(long accountId) {
        return APIResponseUtils.convertMapToObject(getApiResponseMap(QueryParamExtBuilder.newBuilder().withAccountId(accountId).build()));
    }

    @Override
    protected Class<PlayerAchievement> getType() {
        return PlayerAchievement.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return PlayerAchievementConstants.getInstance();
    }
}
