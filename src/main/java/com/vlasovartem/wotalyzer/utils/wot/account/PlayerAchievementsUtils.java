package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerAchievements;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerAchievementsConstants;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.AccountParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayerAchievementsUtils extends MainUtils<PlayerAchievements> {

    public Optional<PlayerAchievements> getPlayerAchievements(long accountId) {
        return APIResponseUtils.convertMapToObject(getApiResponseMap(newBuilder().withAccountId(accountId).build()));
    }

    @Override
    protected Class<PlayerAchievements> getType() {
        return PlayerAchievements.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return PlayerAchievementsConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlayerAchievementsConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlayerAchievementsConstants.REQUIRED_PARAMS;
    }
}
