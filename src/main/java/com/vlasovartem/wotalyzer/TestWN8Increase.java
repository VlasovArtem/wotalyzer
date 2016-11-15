package com.vlasovartem.wotalyzer;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;
import com.vlasovartem.wotalyzer.entity.wn8.RatioData;
import com.vlasovartem.wotalyzer.entity.wn8.TankExpectedData;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.AllStatisticsData;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.components.OverallStatistic;
import com.vlasovartem.wotalyzer.utils.wn8.RatioDataUtils;

import java.util.Collections;

/**
 * Created by artemvlasov on 09/11/2016.
 * Tank damage data:
 * More damage gives more effect on user WN8 (high effect)
 * Tank frags data:
 * If account frags is more than 2 times greater then expected data, than this parameter will not make effect on user WN8 (low effect)
 * Tank wins data:
 * If account wins/battles is greater more than on ~12%, that this parameter will not make effect on user WN8 (low effect)
 * Tank spotted data:
 * If account spotted data is greater more than on ~10% for expected data, than this parameter will not make effect on user WN8 (low effect)
 * Tank capture point:
 * If account data is greater more than on ~10% from expected data and less than, than this parameter will not make effect on user WN8 (low effect)
 */
public class TestWN8Increase {

    private static long damage = 528861;
    private static int frags = 600;
    private static int spotted = 424;
    private static int wins = 200;
    private static int capturePoints = 250;

    public static void main(String[] args) {
        compareData(10);
    }

    private static TankExpectedData getTank121ExpectedData() {
        TankExpectedData tank121 = new TankExpectedData();
        tank121.setExpDamage(1762.87f);
        tank121.setExpDef(0.66f);
        tank121.setExpFrag(0.93f);
        tank121.setExpSpot(1.33f);
        tank121.setExpWin(48.14f);
        tank121.setTankId(4145);
        return tank121;
    }

    private static VehicleStatistic getVehicleStatistic() {
        VehicleStatistic vehicleStatistic = new VehicleStatistic();
        vehicleStatistic.setTankId(4145);
        OverallStatistic overallStatistic = new OverallStatistic();
        overallStatistic.setBattles(300);
        vehicleStatistic.setAll(overallStatistic);
        return vehicleStatistic;
    }

    private static AllStatisticsData getAllStatisticsData(long damageDealth, int frags, int spotted, int wins, int capturePoints) {
        AllStatisticsData allStatisticsData = new AllStatisticsData();
        allStatisticsData.setDamageDealt(damageDealth);
        allStatisticsData.setFrags(frags);
        allStatisticsData.setSpotted(spotted);
        allStatisticsData.setWins(wins);
        allStatisticsData.setDroppedCapturePoints(capturePoints);
        return allStatisticsData;
    }

    private static int getWN8(long damageDealth, int frags, int spotted, int wins, int capturePoints) {
        ExpectedData expectedData = RatioDataUtils.calculateAccountExpectedData(Collections.singletonList(getVehicleStatistic()), Collections.singletonList(getTank121ExpectedData()));
        RatioData accountRationData = RatioDataUtils.calculateAccountRationData(getAllStatisticsData(damageDealth, frags, spotted, wins, capturePoints), expectedData);
        RatioData zeroRatioData = RatioDataUtils.calculateZeroRatioData(accountRationData);
        return RatioDataUtils.calculateWN8(zeroRatioData);
    }

    private static void compareData(int percent) {
        int wn8 = getWN8(damage, frags, spotted, wins, capturePoints);
        int wn8PlusTenPercentDamage = getWN8((long)(damage + (damage * ((float)percent / 100))), frags, spotted, wins, capturePoints);
        int wn8PlusTenPercentFrags = getWN8(damage, (int) (frags + (frags * ((float)percent / 100))), spotted, wins, capturePoints);
        int wn8PlusTenPercentSpotted = getWN8(damage, frags, (int) (spotted + (spotted * ((float)percent / 100))), wins, capturePoints);
        int wn8PlusTenPercentWins = getWN8(damage, frags, spotted, (int) (wins + (wins * ((float)percent / 100))), capturePoints);
        int wn8PlusTenPercentCapture = getWN8(damage, frags, spotted, wins, (int) (capturePoints + (capturePoints * ((float)percent / 100))));
        int wn8All = getWN8((long)(damage + (damage * ((float)percent / 100))), (int) (frags + (frags * ((float)percent / 100))), (int) (spotted + (spotted * ((float)percent / 100))), (int) (wins + (wins * ((float)percent / 100))), (int) (capturePoints + (capturePoints * ((float)percent / 100))));
        System.out.println("Original: " + wn8);
        System.out.println("WN8 Plus 10% Damage: Increase " + (((float) wn8PlusTenPercentDamage / wn8) - 1) * 100 + "% - " + wn8PlusTenPercentDamage);
        System.out.println("WN8 Plus 10% Frags: Increase " + (((float) wn8PlusTenPercentFrags / wn8) - 1) * 100 + "% - " + wn8PlusTenPercentFrags);
        System.out.println("WN8 Plus 10% Spotted: Increase " + (((float) wn8PlusTenPercentSpotted / wn8) - 1) * 100 + "% - " + wn8PlusTenPercentSpotted);
        System.out.println("WN8 Plus 10% Wins: Increase " + (((float) wn8PlusTenPercentWins / wn8) - 1) * 100 + "% - " + wn8PlusTenPercentWins);
        System.out.println("WN8 Plus 10% Capture: Increase " + (((float) wn8PlusTenPercentCapture / wn8) - 1) * 100 + "% - " + wn8PlusTenPercentCapture);
        System.out.println("WN8 Plus 10% All: Increase " + (((float) wn8All / wn8) - 1) * 100 + "% - " + wn8All);
    }

}
