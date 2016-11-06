package com.vlasovartem.wotalyzer.service.statistic;

import com.vlasovartem.wotalyzer.entity.statistic.Statistic;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.ammo.Ammo;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;

/**
 * Created by artemvlasov on 14/01/16.
 */

public interface StatisticService {
    Statistic<Double> bestVehicleDynamic(int tier, boolean ignorePremium);
    Statistic<Double> bestVehicleDynamic(VehicleType type, boolean ignorePremium);
    Statistic<Double> bestVehicleDynamic(int tier, VehicleType type, boolean ignorePremium);
    Statistic<Double> bestVehicleDynamic(boolean ignorePremium);
    Statistic<Ammo> bestVehiclePenetration(int tier, VehicleType type, boolean ignorePremium);
    Statistic<Ammo> bestVehiclePenetration(VehicleType type, boolean ignorePremium);
    Statistic<Ammo> bestVehiclePenetration(int tier, boolean ignorePremium);
    Statistic<Ammo> bestVehiclePenetration(boolean ignorePremium);
    Statistic<Integer> bestVehicleViewRange(int tier, VehicleType type, boolean ignorePremium);
    Statistic<Integer> bestVehicleViewRange(VehicleType type, boolean ignorePremium);
    Statistic<Integer> bestVehicleViewRange(int tier, boolean ignorePremium);
    Statistic<Integer> bestVehicleViewRange(boolean ignorePremium);
    Statistic<Double> compareVehicleDynamic(int tier, long tankId, boolean ignorePremium);
    Statistic<Double> compareVehicleDynamic(VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Double> compareVehicleDynamic(int tier, VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Double> compareVehicleDynamic(long tankId, boolean ignorePremium);
    Statistic<Ammo> compareVehiclePenetration(int tier, VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Ammo> compareVehiclePenetration(VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Ammo> compareVehiclePenetration(int tier, long tankId, boolean ignorePremium);
    Statistic<Ammo> compareVehiclePenetration(long tankId, boolean ignorePremium);
    Statistic<Integer> compareVehicleViewRange(int tier, VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Integer> compareVehicleViewRange(VehicleType type, long tankId, boolean ignorePremium);
    Statistic<Integer> compareVehicleViewRange(int tier, long tankId, boolean ignorePremium);
    Statistic<Integer> compareVehicleViewRange(long tankId, boolean ignorePremium);

}
