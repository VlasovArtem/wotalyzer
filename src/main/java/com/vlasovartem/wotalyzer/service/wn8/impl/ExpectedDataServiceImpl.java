package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.service.wn8.ExpectedDataService;
import com.vlasovartem.wotalyzer.service.wn8.TankExpectedDataService;
import com.vlasovartem.wotalyzer.service.wot.api.player_vehicles.impl.VehicleStatisticServiceImpl;
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
        List<VehicleStatistic> accountVehicles = vehicleStatisticService.getAccountVehicles(accountId);
        List<TankExpectedData> vehiclesExpectedData = tankExpectedDataService.findVehiclesExpectedData(vehicleStatisticService.getAccountTankIds(accountVehicles));
        ExpectedData expectedData = new ExpectedData();
        vehiclesExpectedData.forEach(tankExpectedData -> {
            Optional<Integer> battles = accountVehicles.stream()
                    .filter(vehicleStatistic -> vehicleStatistic.getTankId() == tankExpectedData.getTankId())
                    .map(vehicleStatistic -> vehicleStatistic.getAll().getBattles())
                    .findFirst();
            expectedData.setExpDamage(expectedData.getExpDamage() + battles.get() * tankExpectedData.getExpDamage());
            expectedData.setExpDef(expectedData.getExpDef() + battles.get() * tankExpectedData.getExpDef());
            expectedData.setExpFrag(expectedData.getExpFrag() + battles.get() * tankExpectedData.getExpFrag());
            expectedData.setExpSpot(expectedData.getExpSpot() + battles.get() * tankExpectedData.getExpSpot());
            expectedData.setExpWin(expectedData.getExpWin() + 0.01f * battles.get() * tankExpectedData.getExpWin());
        });
        return expectedData;
    }
}
