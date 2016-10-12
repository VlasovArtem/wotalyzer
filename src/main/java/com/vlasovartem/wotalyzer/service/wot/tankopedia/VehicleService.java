package com.vlasovartem.wotalyzer.service.wot.tankopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.VehicleProfile;

import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleService {
    List<VehicleProfile> getVehicles (List<Long> tankIds);
    List<VehicleProfile> getVehicles (List<Long> tankIds, List<String> requiredFields);
    List<VehicleProfile> getVehicles (List<Long> tankIds, Map<String, Object> params);
    VehicleProfile getVehicle (long tankId);
    VehicleProfile getVehicle (long tankId, List<String> requiredFields);
    VehicleProfile getVehicle (Map<String, Object> param);
    VehicleProfile getVehicle (VehicleModuleInfo moduleInfo, List<String> fields);
}
