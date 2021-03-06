package com.vlasovartem.wotalyzer.utils.wot.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleAchievement;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles.VehicleAchievementConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.QueryParamExtBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.IN_GARAGE_PARAM;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class VehicleAchievementUtils extends MainUtils<VehicleAchievement> {

    public List<VehicleAchievement> getVehicleAchievements(long accountId) {
        APIResponse<Map<String, List<VehicleAchievement>>> apiResponse = getApiResponseMapList(QueryParamExtBuilder.newBuilder().withAccountId(accountId).build());
        Optional<Map<String, List<VehicleAchievement>>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return content.get().get(String.valueOf(accountId));
        }
        return Collections.emptyList();
    }

    @Override
    protected Class<VehicleAchievement> getType() {
        return VehicleAchievement.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return VehicleAchievementConstants.getInstance();
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
