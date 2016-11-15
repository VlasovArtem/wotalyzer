package com.vlasovartem.wotalyzer.utils.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.RatioData;
import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.AllStatisticsData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by artemvlasov on 09/11/2016.
 */
public class RatioDataUtils {

    public static ExpectedData calculateAccountExpectedData(List<VehicleStatistic> accountVehicleStatistic, List<TankExpectedData> vehiclesExpectedData) {
        ExpectedData expectedData = new ExpectedData();
        vehiclesExpectedData.forEach(tankExpectedData -> {
            Optional<Long> battles = accountVehicleStatistic.stream()
                    .filter(vehicleStatistic -> vehicleStatistic.getTankId() == tankExpectedData.getTankId())
                    .map(vehicleStatistic -> vehicleStatistic.getAll().getBattles())
                    .findFirst();
            collectExpectedData(battles.get(), expectedData).accept(tankExpectedData);
        });
        return expectedData;
    }

    public static ExpectedData calculateAccountExpectedData(VehicleStatistic accountVehicleStatistic, TankExpectedData vehicleExpectedData) {
        ExpectedData expectedData = new ExpectedData();
        long battles = accountVehicleStatistic.getAll().getBattles();
        collectExpectedData(battles, expectedData).accept(vehicleExpectedData);
        return expectedData;
    }

    public static RatioData calculateAccountRationData(AllStatisticsData allStatisticsData, ExpectedData accountExpectedData) {
        RatioData ratioData = new RatioData();
        ratioData.setDamage(allStatisticsData.getDamageDealt() / accountExpectedData.getExpDamage());
        ratioData.setFrag(allStatisticsData.getFrags() / accountExpectedData.getExpFrag());
        ratioData.setSpot(allStatisticsData.getSpotted() / accountExpectedData.getExpSpot());
        ratioData.setWinRate(allStatisticsData.getWins() / accountExpectedData.getExpWin());
        ratioData.setDef(allStatisticsData.getDroppedCapturePoints() / accountExpectedData.getExpDef());
        return ratioData;
    }

    public static RatioData calculateZeroRatioData(RatioData accountRatioData) {
        RatioData zeroRatioData = new RatioData();
        zeroRatioData.setWinRate(Double.max(0, (accountRatioData.getWinRate() - 0.71) / (1 - 0.71)));
        zeroRatioData.setDamage(Double.max(0, (accountRatioData.getDamage() - 0.22) / (1 - 0.22)));
        zeroRatioData.setFrag(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.2,
                (accountRatioData.getFrag() - 0.12) / (1 - 0.12))));
        zeroRatioData.setSpot(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.1,
                (accountRatioData.getSpot() - 0.38) / (1 - 0.38))));
        zeroRatioData.setDef(Double.max(0, Double.min(zeroRatioData.getDamage() + 0.1,
                (accountRatioData.getDef() - 0.10) / (1 - 0.10))));
        return zeroRatioData;
    }

    public static int calculateWN8(RatioData zeroRatioData) {
        return (int)
                (980 * zeroRatioData.getDamage() +
                        210 * zeroRatioData.getDamage() * zeroRatioData.getFrag() +
                        155 * zeroRatioData.getFrag() * zeroRatioData.getSpot() +
                        75 * zeroRatioData.getDef() * zeroRatioData.getFrag() +
                        145 * Double.min(1.8, zeroRatioData.getWinRate()));
    }
    
    private static Consumer<TankExpectedData> collectExpectedData(long battles, ExpectedData expectedData) {
        return tankExpectedData -> {
            expectedData.setExpDamage(expectedData.getExpDamage() + battles * tankExpectedData.getExpDamage());
            expectedData.setExpDef(expectedData.getExpDef() + battles * tankExpectedData.getExpDef());
            expectedData.setExpFrag(expectedData.getExpFrag() + battles * tankExpectedData.getExpFrag());
            expectedData.setExpSpot(expectedData.getExpSpot() + battles * tankExpectedData.getExpSpot());
            expectedData.setExpWin(expectedData.getExpWin() + 0.01f * battles * tankExpectedData.getExpWin());
        };
    } 

}
