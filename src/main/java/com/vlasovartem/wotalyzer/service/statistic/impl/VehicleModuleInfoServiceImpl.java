package com.vlasovartem.wotalyzer.service.statistic.impl;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.service.statistic.VehicleModuleInfoService;
import com.vlasovartem.wotalyzer.service.wot.encyclopedia.VehiclesService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.wot.encyclopedia.VehicleCharacteristicUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Service
public class VehicleModuleInfoServiceImpl implements VehicleModuleInfoService {

    private final static Logger LOGGER = LogManager.getLogger(VehicleModuleInfoServiceImpl.class);
    private VehicleCharacteristicUtils vehicleCharacteristicUtils;
    private TankUtils tankUtils;
    private VehiclesService vehiclesService;

    @Autowired
    public VehicleModuleInfoServiceImpl(VehicleCharacteristicUtils vehicleCharacteristicUtils, TankUtils tankUtils, VehiclesService vehiclesService) {
        this.vehicleCharacteristicUtils = vehicleCharacteristicUtils;
        this.tankUtils = tankUtils;
        this.vehiclesService = vehiclesService;
    }

    @Override
    public VehicleModuleInfo findVehicleComponentInfoData(long tankId) {
        //TODO
//        VehicleModuleInfo info = new VehicleModuleInfo();
//        info.setTankId(tankId);
//        Vehicle tankBaseInfo = vehiclesService.findById(tankId, Arrays.asList("modules_tree", TANK_ID_PARAM, "default_profile"));
//        if(Objects.nonNull(tankBaseInfo)) {
//            VehicleModuleComponent defaultComponents = new VehicleModuleComponent();
//            if(Objects.nonNull(tankBaseInfo.getDefaultProfile().getModules())) {
//                Modules modules = tankBaseInfo.getDefaultProfile().getModules();
//                defaultComponents.setGunId(modules.getGunId() == 0 ? null : (long) modules.getGunId());
//                defaultComponents.setEngineId(modules.getEngineId() == 0 ? null : (long) modules.getEngineId());
//                defaultComponents.setSuspensionId(modules.getSuspensionId() == 0 ? null : (long) modules.getSuspensionId());
//                defaultComponents.setRadioId(modules.getRadioId() == 0 ? null : (long) modules.getRadioId());
//                defaultComponents.setTurretId(modules.getTurretId() == 0 ? null : (long) modules.getTurretId());
//            }
//            info.setDefaultModules(defaultComponents);
//            WotMap<String, Object> moduleMap = tankUtils.generateVehicleTopModuleMap(tankBaseInfo);
//            String url = vehicleProfileUtils.vehicleUri(moduleMap);
//            info.setTopModuleUrl(url);
//            if(Objects.nonNull(moduleMap)) {
//                VehicleModuleComponent topComponents = new VehicleModuleComponent();
//                Object engineId = moduleMap.get(ENGINE_ID_PARAM);
//                if(Objects.nonNull(engineId)) {
//                    topComponents.setEngineId((Long) engineId);
//                }
//                Object gunId = moduleMap.get(GUN_ID_PARAM);
//                if(Objects.nonNull(gunId)) {
//                    topComponents.setGunId((Long) gunId);
//                }
//                Object turretId = moduleMap.get(TURRET_ID_PARAM);
//                if(Objects.nonNull(turretId)) {
//                    topComponents.setTurretId((Long) turretId);
//                }
//                Object suspensionID = moduleMap.get(SUSPENSION_ID_PARAM);
//                if(Objects.nonNull(suspensionID)) {
//                    topComponents.setSuspensionId((Long) suspensionID);
//                }
//                Object radioId = moduleMap.get(RADIO_ID_PARAM);
//                if(Objects.nonNull(radioId)) {
//                    topComponents.setRadioId((Long) radioId);
//                }
//                info.setTopModules(topComponents);
//            }
//            return info;
//        }
//        LOGGER.warn("VehicleUtils base info is not found for tank with id {}", tankId);
        return null;
    }
}
