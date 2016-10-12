package com.vlasovartem.wotalyzer.utils.uri.wot.api.tanks;

import com.vlasovartem.wotalyzer.entity.wot.api.tanks.Achievement;
import com.vlasovartem.wotalyzer.utils.api.contstans.tanks.AchievementConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.IN_GARAGE_PARAM;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class AchievementUtils extends MainUtils<Achievement> {

    public AchievementUtils() {
        super(Achievement.class);
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

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if (checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case IN_GARAGE_PARAM:
                        int value = (int) entrySet.getValue();
                        return value == 0 || value == 1;
                }
            }
        }
        return true;
    }
}
