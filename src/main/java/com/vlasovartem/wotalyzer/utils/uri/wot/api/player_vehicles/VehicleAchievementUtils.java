package com.vlasovartem.wotalyzer.utils.uri.wot.api.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleAchievement;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles.VehicleAchievementConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.IN_GARAGE_PARAM;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class VehicleAchievementUtils extends MainUtils<VehicleAchievement> {

    @Override
    protected Class getType() {
        return VehicleAchievement.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleAchievementConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleAchievementConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleAchievementConstants.REQUIRED_PARAMS;
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
