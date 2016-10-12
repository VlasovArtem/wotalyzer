package com.vlasovartem.wotalyzer.service.statistic;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleModuleInfoService {
    VehicleModuleInfo findVehicleComponentInfoData(long tankId);
}
