package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.achievement.Achievement;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.AchievementConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component("EncyclopediaAchievementUtils")
public class AchievementUtils extends MainUtils<Achievement> {

    @Override
    protected Class getType() {
        return Achievement.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return AchievementConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return AchievementConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return AchievementConstants.REQUIRED_PARAMS;
    }
}
