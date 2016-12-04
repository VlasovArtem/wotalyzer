package com.vlasovartem.wotalyzer.service.wot.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 03/11/2016.
 */
@Service
public interface VehicleStatisticService {

    List<Integer> getAccountTankIds(long accountId);
    List<VehicleStatistic> getAccountVehicles(long accountId);
    List<Integer> getAccountTankIds(List<VehicleStatistic> vehicleStatistics);
    Optional<VehicleStatistic> getAccountVehiclesByTankId(int accountId, int tankId);
    List<VehicleStatistic> getAccountVehiclesByTankIds(int accountId, List<Integer> tankIds);
    List<VehicleStatistic> getAccountVehiclesByTier(int accountId, int tier);
    List<VehicleStatistic> getAccountVehiclesByTierBetween(int accountId, int minTier, int maxTier);

}
