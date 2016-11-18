package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerAchievements;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerAchievementsConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayerAchievementsUtils extends MainUtils<PlayerAchievements> {

    public PlayerAchievementsUtils() {
        super();
    }

    @Override
    protected Class getType() {
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
