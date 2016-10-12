package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.achievements.Achievements;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.AchievementsConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component
public class AchievementsUtils extends MainUtils<Achievements> {

    AchievementsUtils() {
        super(Achievements.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return AchievementsConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return AchievementsConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return AchievementsConstants.REQUIRED_PARAMS;
    }
}
