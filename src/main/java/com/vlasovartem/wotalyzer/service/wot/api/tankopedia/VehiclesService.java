package com.vlasovartem.wotalyzer.service.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicles;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehiclesService {
    String getVehicleType (long tankId);
    int getVehicleTier (long tankId);
    boolean isPremium (long tankId);
    Vehicles findById(long id, List<String> fields);
    List<Vehicles> findByTierAndType(Integer tier, VehicleType type, List<String> requiredFields);
    List<Vehicles> findByTierAndType(Integer tier, List<String> requiredFields);
    List<Vehicles> findByTierAndType(VehicleType type, List<String> requiredFields);
    List<Vehicles> findByTierAndType(List<String> requiredFields);
    List<Vehicles> findAll(List<String> fields);
}
