package com.vlasovartem.wotalyzer.service.wot.api.player_vehicles.impl;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMapList;
import com.vlasovartem.wotalyzer.service.wot.api.player_vehicles.VehicleStatisticService;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.player_vehicles.VehicleStatisticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.QueryParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public class VehicleStatisticServiceImpl implements VehicleStatisticService {

    private final VehicleStatisticUtils vehicleStatisticUtils;

    @Autowired
    public VehicleStatisticServiceImpl(VehicleStatisticUtils vehicleStatisticUtils) {
        this.vehicleStatisticUtils = vehicleStatisticUtils;
    }

    public List<Long> getAccountTankIds(long accountId) {
        return getAccountTankIds(getAccountVehicles(accountId));
    }

    public List<VehicleStatistic> getAccountVehicles(long accountId) {
        APIResponseMapList<VehicleStatistic> apiResponse = vehicleStatisticUtils.getApiResponseMapList(newBuilder().withAccountId(accountId).build());
        Optional<List<VehicleStatistic>> responseContent = apiResponse.getContent().stream().findFirst();
        if (responseContent.isPresent()) {
            return responseContent.get();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Long> getAccountTankIds(List<VehicleStatistic> vehicleStatistics) {
        return vehicleStatistics.stream().map(VehicleStatistic::getTankId).collect(Collectors.toList());
    }
}
