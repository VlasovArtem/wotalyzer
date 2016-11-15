package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.increase.AccountWN8Increase;
import com.vlasovartem.wotalyzer.entity.wn8.increase.TankWN8IncreaseIndicator;
import com.vlasovartem.wotalyzer.entity.wn8.increase.TankWN8IncreaseIndicatorBuilder;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.service.wn8.AccountWN8IncreaseService;
import com.vlasovartem.wotalyzer.service.wn8.TankExpectedDataService;
import com.vlasovartem.wotalyzer.service.wot.api.player_vehicles.impl.VehicleStatisticServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 12/11/2016.
 */
@Service
public class AccountWN8IncreaseServiceImpl implements AccountWN8IncreaseService {

    private static final Logger LOGGER = LogManager.getLogger(AccountWN8IncreaseService.class);
    private final TankExpectedDataService tankExpectedDataService;
    private final VehicleStatisticServiceImpl vehicleStatisticService;

    @Autowired
    public AccountWN8IncreaseServiceImpl(TankExpectedDataService tankExpectedDataService, VehicleStatisticServiceImpl vehicleStatisticService) {
        this.tankExpectedDataService = tankExpectedDataService;
        this.vehicleStatisticService = vehicleStatisticService;
    }

    /**
     * Get Account WN8 increase data indicators by accountID and tank tier
     *
     * @param accountId account id
     * @param tankTier tank tier
     * @return Account WN8 Increase data
     */
    @Override
    public AccountWN8Increase getAccountWN8IncreaseData(int accountId, int tankTier) {
        List<VehicleStatistic> vehicleStatistics = vehicleStatisticService.getAccountVehiclesByTier(accountId, tankTier);
        List<TankExpectedData> tankExpectedData = tankExpectedDataService.findByIds(vehicleStatisticService.getAccountTankIds(vehicleStatistics));
        List<TankWN8IncreaseIndicator> indicators = getIndicators(vehicleStatistics, tankExpectedData);
        return new AccountWN8Increase(accountId, indicators);
    }

    /**
     * Get Account WN8 Increase data by account id and tank tier between min and max
     *
     * @param accountId account id
     * @param minTankTier min tank tier
     * @param maxTankTier max tank tier
     * @return Account WN8 Increase data
     */
    @Override
    public AccountWN8Increase getAccountWN8IncreaseData(int accountId, int minTankTier, int maxTankTier) {
        List<VehicleStatistic> vehicleStatistics = vehicleStatisticService.getAccountVehiclesByTierBetween(accountId, minTankTier, maxTankTier);
        List<TankExpectedData> tankExpectedData = tankExpectedDataService.findByIds(vehicleStatisticService.getAccountTankIds(vehicleStatistics));
        List<TankWN8IncreaseIndicator> indicators = getIndicators(vehicleStatistics, tankExpectedData);
        return new AccountWN8Increase(accountId, indicators);
    }

    /**
     * Calculate Increase WN8 indicators, based on all vehicle statistic and tank expected data.
     * Please reference to {@link TankWN8IncreaseIndicatorBuilder} for more information.
     *
     * @param vehicleStatistics vehicle statistics
     * @param tankExpectedData tanks expected data
     * @return List of Indicators
     */
    private List<TankWN8IncreaseIndicator> getIndicators(List<VehicleStatistic> vehicleStatistics, List<TankExpectedData> tankExpectedData) {
        return vehicleStatistics.parallelStream()
                .filter(vehicleStatistic -> vehicleStatistic.isInGarage() &&
                        tankExpectedData.stream().anyMatch(ted -> ted.getTankId() == vehicleStatistic.getTankId()))
                .map(vehicleStatistic -> {
                    Optional<TankExpectedData> expectedData = tankExpectedData.stream()
                            .filter(tankExpData -> tankExpData.getTankId() == vehicleStatistic.getTankId())
                            .findFirst();
                        return TankWN8IncreaseIndicatorBuilder.getInstance(vehicleStatistic.getTankId(), vehicleStatistic.getAll().getBattles())
                                .checkDamage(vehicleStatistic.getAll().getDamageDealt(), expectedData.get().getExpDamage())
                                .checkDefence(vehicleStatistic.getAll().getDroppedCapturePoints(), expectedData.get().getExpDef())
                                .checkFrags(vehicleStatistic.getAll().getFrags(), expectedData.get().getExpFrag())
                                .checkSpotted(vehicleStatistic.getAll().getSpotted(), expectedData.get().getExpSpot())
                                .checkWinRate(vehicleStatistic.getAll().getWins(), expectedData.get().getExpWin())
                                .build();
                })
                .collect(Collectors.toList());

    }


}
