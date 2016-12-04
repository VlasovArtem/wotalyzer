package com.vlasovartem.wotalyzer.service.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleCharacteristic;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleService {
    List<VehicleCharacteristic> getVehicles (List<Long> tankIds);
    List<VehicleCharacteristic> getVehicles (List<Long> tankIds, List<String> requiredFields);
    VehicleCharacteristic getVehicle (long tankId);
    VehicleCharacteristic getVehicle (long tankId, List<String> requiredFields);
    VehicleCharacteristic getVehicle (VehicleModuleInfo moduleInfo, List<String> fields);
}
