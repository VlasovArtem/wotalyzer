package com.vlasovartem.wotalyzer.utils;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.ModulesTree;
import com.vlasovartem.wotalyzer.utils.exception.TankJsonConverterException;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia.VehicleProfileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 13/01/16.
 */
@Component
public class TankUtils {

    private static final Logger LOGGER = LogManager.getLogger(TankUtils.class);

    @Autowired
    private VehicleProfileUtils vehicleProfileUtils;
    private Map<String, String> tankModuleMap;

    public TankUtils() {
        tankModuleMap = new HashMap<>();
        tankModuleMap.put("vehicleRadio", "radio_id");
        tankModuleMap.put("vehicleChassis", "suspension_id");
        tankModuleMap.put("vehicleTurret", "turret_id");
        tankModuleMap.put("vehicleGun", "gun_id");
        tankModuleMap.put("vehicleEngine", "engine_id");
    }

//    /**
//     * Find VehicleUtils with top modules
//     *
//     * @param tankId id of the tank
//     * @return VehicleUtils object that created form json response
//     */
//    public com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.VehicleProfile topModuleVehicle(long tankId) {
//        return vehicleUtils
//                .getApiResponse(com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.VehicleProfile.class, generateVehicleTopModuleMap(vehicleUtils
//                        .getVehicleApiResponse(Vehicle.class, tankId, Arrays.asList("modules_tree", VehicleBasicConstants.TANK_ID_PARAM))
//                        .getData().get(String.valueOf(tankId))))
//                .getData().get(String.valueOf(tankId));
//    }

    /**
     * Generate VehicleUtils top module map, that contains param from API and numeric value of the module id
     *
     * @param info   Basic info about VehicleUtils from the Vehicle API
     * @return return man with query param and id
     */
    public Map<String, Object> generateVehicleTopModuleMap(Vehicle info) {
        info = Optional.ofNullable(info).orElseThrow(TankJsonConverterException::new);
        Map<String, ModulesTree> treeMap = info.getModulesTree();
        Map<String, Object> topModuleTankMap = new HashMap<>();
        if (Objects.nonNull(treeMap)) {
            topModuleTankMap = treeMap.entrySet().stream()
                    .map(Map.Entry::getValue)
                    .collect(
                            Collectors.toMap(mt -> tankModuleMap.get(mt.getType()), mt -> mt, (o, o2) -> {
                                if(o.isDefault() ||
                                        (Objects.nonNull(o.getNextModules()) &&
                                                Objects.nonNull(o2.getNextModules()) &&
                                                o.getNextModules().contains((int) o2.getModuleId())) ||
                                        o.getPriceCredit() < o2.getPriceCredit() ||
                                        o.getPriceXp() < o2.getPriceXp()) {
                                    return o2;
                                }
                                return o;
                            }))
                    .entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, mt -> mt.getValue().getModuleId()));
        } else
            LOGGER.warn("Module tree map for tank with id {} is not found", info.getId());
        topModuleTankMap.put("tank_id", info.getId());
        return topModuleTankMap;
    }
}
