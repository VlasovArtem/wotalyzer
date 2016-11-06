package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMapList;
import com.vlasovartem.wotalyzer.repository.wn8.TankExpectedDataRepository;
import com.vlasovartem.wotalyzer.service.wn8.TankExpectedDataService;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.player_vehicles.VehicleStatisticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.QueryParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 01/11/2016.
 */
@Service
public class TankExpectedDataServiceImpl implements TankExpectedDataService {

    private final TankExpectedDataRepository repository;
    private final VehicleStatisticUtils vehicleStatisticUtils;

    @Autowired
    public TankExpectedDataServiceImpl(TankExpectedDataRepository repository, VehicleStatisticUtils vehicleStatisticUtils) {
        this.repository = repository;
        this.vehicleStatisticUtils = vehicleStatisticUtils;
    }

    @Override
    public TankExpectedData findById(long tankId) {
        return repository.findOne(tankId);
    }

    @Override
    public List<TankExpectedData> findByIds(List<Long> tankIds) {
        return repository.findByTankIdIn(tankIds);
    }

    @Override
    public List<TankExpectedData> findUserVehicleExpectedData(long accountId) {
        APIResponseMapList<VehicleStatistic> apiResponse = vehicleStatisticUtils.getApiResponseMapList(newBuilder().withAccountId(accountId).build());
        Optional<List<VehicleStatistic>> responseContent = apiResponse.getContent().stream().findFirst();
        if (responseContent.isPresent()) {
            List<VehicleStatistic> vehicleStatistics = responseContent.get();
            List<Long> accountTankIds = vehicleStatistics.stream().map(VehicleStatistic::getTankId).collect(Collectors.toList());
            return findVehiclesExpectedData(accountTankIds);
        }
        return Collections.emptyList();
    }

    @Override
    public List<TankExpectedData> findVehiclesExpectedData(List<Long> tankIds) {
        return repository.findByTankIdIn(tankIds);
    }
}
