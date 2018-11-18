package com.vlasovartem.wotalyzer.service.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleService {
    List<VehicleProfile> getVehicles (List<Long> tankIds);
    List<VehicleProfile> getVehicles (List<Long> tankIds, List<String> requiredFields);
    VehicleProfile getVehicle (long tankId);
    VehicleProfile getVehicle (long tankId, List<String> requiredFields);
    VehicleProfile getVehicle (VehicleModuleInfo moduleInfo, List<String> fields);
}
