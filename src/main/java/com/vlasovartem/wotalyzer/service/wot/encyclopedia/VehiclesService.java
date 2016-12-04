package com.vlasovartem.wotalyzer.service.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehiclesService {
    String getVehicleType (long tankId);
    int getVehicleTier (long tankId);
    boolean isPremium (long tankId);
    Vehicle findById(long id, List<String> fields);
    List<Vehicle> findByTierAndType(Integer tier, VehicleType type, List<String> requiredFields);
    List<Vehicle> findByTierAndType(Integer tier, List<String> requiredFields);
    List<Vehicle> findByTierAndType(VehicleType type, List<String> requiredFields);
    List<Vehicle> findByTierAndType(List<String> requiredFields);
    List<Vehicle> findAll(List<String> fields);
}
