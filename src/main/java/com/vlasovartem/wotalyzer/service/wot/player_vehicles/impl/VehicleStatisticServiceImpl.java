package com.vlasovartem.wotalyzer.service.wot.player_vehicles.impl;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.service.wot.player_vehicles.VehicleStatisticService;
import com.vlasovartem.wotalyzer.utils.wot.encyclopedia.VehicleUtils;
import com.vlasovartem.wotalyzer.utils.wot.player_vehicles.VehicleStatisticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public class VehicleStatisticServiceImpl implements VehicleStatisticService {

    private final VehicleStatisticUtils vehicleStatisticUtils;
    private final VehicleUtils vehicleUtils;

    @Autowired
    public VehicleStatisticServiceImpl(VehicleStatisticUtils vehicleStatisticUtils, VehicleUtils vehicleUtils) {
        this.vehicleStatisticUtils = vehicleStatisticUtils;
        this.vehicleUtils = vehicleUtils;
    }

    public List<Integer> getAccountTankIds(long accountId) {
        return getAccountTankIds(getAccountVehicles(accountId));
    }

    public List<VehicleStatistic> getAccountVehicles(long accountId) {
        return vehicleStatisticUtils.getVehicleStatistics(accountId);
    }

    @Override
    public List<Integer> getAccountTankIds(List<VehicleStatistic> vehicleStatistics) {
        return vehicleStatistics.stream().map(VehicleStatistic::getTankId).collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleStatistic> getAccountVehiclesByTankId(int accountId, int tankId) {
        return getAccountVehicles(accountId)
                .parallelStream()
                .filter(vehicleStatistic -> vehicleStatistic.getTankId() == tankId)
                .findFirst();
    }

    @Override
    public List<VehicleStatistic> getAccountVehiclesByTankIds(int accountId, List<Integer> tankIds) {
        return getAccountVehicles(accountId)
                .parallelStream()
                .filter(vehicleStatistic -> tankIds.contains(vehicleStatistic.getTankId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleStatistic> getAccountVehiclesByTier(int accountId, int tier) {
        return getVehicleStatisticByTierFunction(accountId, vehicle -> vehicle.getTier() == tier);
    }

    @Override
    public List<VehicleStatistic> getAccountVehiclesByTierBetween(int accountId, int minTier, int maxTier) {
        return getVehicleStatisticByTierFunction(accountId, vehicle -> vehicle.getTier() >= minTier && vehicle.getTier() <= maxTier);
    }

    private List<VehicleStatistic> getVehicleStatisticByTierFunction(int accountId, Predicate<Vehicle> filterFunction) {
        //TODO
        List<VehicleStatistic> accountVehicles = getAccountVehicles(accountId);
        List<Integer> accountTankIds = getAccountTankIds(accountVehicles);
//        Optional<List<Vehicle>> vehicles = vehicleUtils.getVehiclesApiResponse(accountTankIds).getContent();
        Optional<List<Vehicle>> vehicles = Optional.empty();
        if (vehicles.isPresent()) {
            List<Vehicle> tierVehicles = vehicles.get()
                    .parallelStream()
                    .filter(filterFunction)
                    .collect(Collectors.toList());
            return accountVehicles
                    .parallelStream()
                    .filter(vehicleStatistic -> tierVehicles.stream().anyMatch(tierVehicle -> tierVehicle.getId() == vehicleStatistic.getTankId()))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
