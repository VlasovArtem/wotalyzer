package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.service.wn8.ExpectedDataService;
import com.vlasovartem.wotalyzer.service.wn8.TankExpectedDataService;
import com.vlasovartem.wotalyzer.service.wot.api.player_vehicles.impl.VehicleStatisticServiceImpl;
import com.vlasovartem.wotalyzer.utils.wn8.RatioDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public class ExpectedDataServiceImpl implements ExpectedDataService {

    private final TankExpectedDataService tankExpectedDataService;
    private final VehicleStatisticServiceImpl vehicleStatisticService;


    @Autowired
    public ExpectedDataServiceImpl(TankExpectedDataService dataService, VehicleStatisticServiceImpl vehicleStatisticService) {
        this.tankExpectedDataService = dataService;
        this.vehicleStatisticService = vehicleStatisticService;
    }

    @Override
    public ExpectedData getAccountExpectedData(long accountId) {
        return collectExpectedData(vehicleStatisticService.getAccountVehicles(accountId));
    }

    @Override
    public Optional<ExpectedData> getAccountExpectedDataByTankId(int accountId, int tankId) {
        Optional<VehicleStatistic> accountVehicles = vehicleStatisticService.getAccountVehiclesByTankId(accountId, tankId);
        if (accountVehicles.isPresent()) {
            TankExpectedData tankExpectedData = tankExpectedDataService.findById(accountVehicles.get().getTankId());
            return Optional.ofNullable(RatioDataUtils.calculateAccountExpectedData(accountVehicles.get(), tankExpectedData));
        }
        return Optional.empty();
    }

    @Override
    public ExpectedData getAccountExpectedDataByTankIds(int accountId, List<Integer> tankIds) {
        return collectExpectedData(vehicleStatisticService.getAccountVehiclesByTankIds(accountId, tankIds));
    }

    @Override
    public ExpectedData getAccountExpectedDataByTier(int accountId, int tier) {
        return collectExpectedData(vehicleStatisticService.getAccountVehiclesByTier(accountId, tier));
    }

    @Override
    public ExpectedData getAccountExpectedDataByTierBetween(int account, int minTier, int maxTier) {
        return collectExpectedData(vehicleStatisticService.getAccountVehiclesByTierBetween(account, minTier, maxTier));
    }

    private ExpectedData collectExpectedData(List<VehicleStatistic> accountVehicles) {
        List<TankExpectedData> vehiclesExpectedData = tankExpectedDataService.findByIds(vehicleStatisticService.getAccountTankIds(accountVehicles));
        return RatioDataUtils.calculateAccountExpectedData(accountVehicles, vehiclesExpectedData);
    }
}
