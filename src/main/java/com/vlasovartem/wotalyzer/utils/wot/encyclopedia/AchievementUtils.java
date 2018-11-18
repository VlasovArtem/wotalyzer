package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Achievement;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.AchievementConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component("EncyclopediaAchievementUtils")
public class AchievementUtils extends MainUtils<Achievement> {

    public List<Achievement> getAchievements() {
        return convertMapToList(getApiResponseMap(""));
    }

    @Override
    protected Class<Achievement> getType() {
        return Achievement.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return AchievementConstants.getInstance();
    }
}
