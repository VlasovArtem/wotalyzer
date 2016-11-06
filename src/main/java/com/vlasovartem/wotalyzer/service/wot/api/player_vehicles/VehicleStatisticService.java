package com.vlasovartem.wotalyzer.service.wot.api.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public interface VehicleStatisticService {

    List<Long> getAccountTankIds(long accountId);
    List<VehicleStatistic> getAccountVehicles(long accountId);
    List<Long> getAccountTankIds(List<VehicleStatistic> vehicleStatistics);

}
