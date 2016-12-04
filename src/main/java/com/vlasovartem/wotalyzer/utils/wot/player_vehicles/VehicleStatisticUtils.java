package com.vlasovartem.wotalyzer.utils.wot.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles.VehicleStatisticConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.AccountParamBuilder.newBuilder;


/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class VehicleStatisticUtils extends MainUtils<VehicleStatistic> {

    public List<VehicleStatistic> getVehicleStatistics(long accountId) {
        APIResponse<Map<String, List<VehicleStatistic>>> vehicleStatisticApiResponse = getApiResponseMapList(newBuilder().withAccountId(accountId).build());
        Optional<Map<String, List<VehicleStatistic>>> contentData = vehicleStatisticApiResponse.getContent();
        if (contentData.isPresent()) {
            return contentData.get().get(String.valueOf(accountId));
        }
        return Collections.emptyList();
    }

    @Override
    protected Class<VehicleStatistic> getType() {
        return VehicleStatistic.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleStatisticConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleStatisticConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleStatisticConstants.REQUIRED_PARAMS;
    }
}
