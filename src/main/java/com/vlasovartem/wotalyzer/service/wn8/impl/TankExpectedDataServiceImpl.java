package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.repository.wn8.TankExpectedDataRepository;
import com.vlasovartem.wotalyzer.service.wn8.TankExpectedDataService;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.player_vehicles.VehicleStatisticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<TankExpectedData> findByIds(List<Integer> tankIds) {
        return repository.findByTankIdIn(tankIds);
    }

    @Override
    public List<TankExpectedData> findUserVehicleExpectedData(int accountId) {
        List<Integer> accountTankIds = vehicleStatisticUtils.getVehicleStatistics(accountId).stream().map(VehicleStatistic::getTankId).collect(Collectors.toList());
        return findByIds(accountTankIds);
    }
}
