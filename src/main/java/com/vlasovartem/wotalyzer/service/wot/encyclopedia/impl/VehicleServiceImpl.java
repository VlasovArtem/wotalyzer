package com.vlasovartem.wotalyzer.service.wot.encyclopedia.impl;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleCharacteristic;
import com.vlasovartem.wotalyzer.service.wot.encyclopedia.VehicleService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.wot.encyclopedia.VehicleCharacteristicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private TankUtils tankUtils;
    private VehicleCharacteristicUtils wotApiURIUtils;

    @Autowired
    public VehicleServiceImpl(TankUtils tankUtils, VehicleCharacteristicUtils wotApiURIUtils) {
        this.tankUtils = tankUtils;
        this.wotApiURIUtils = wotApiURIUtils;
    }

    @Override
    public List<VehicleCharacteristic> getVehicles(List<Long> tankIds) {
        return tankIds.stream().map(this::getVehicle).collect(Collectors.toList());
    }

    @Override
    public List<VehicleCharacteristic> getVehicles(List<Long> tankIds, List<String> requiredFields) {
        return tankIds.stream().map(id -> getVehicle(id, requiredFields)).collect(Collectors.toList());
    }


    @Override
    public VehicleCharacteristic getVehicle(long tankId) {
        return getVehicleObject(tankId);
    }

    @Override
    public VehicleCharacteristic getVehicle(long tankId, List<String> requiredFields) {
        return getVehicleObject(tankId, requiredFields);
    }

    @Override
    public VehicleCharacteristic getVehicle(VehicleModuleInfo moduleInfo, List<String> fields) {
        //TODO
//        if(Objects.nonNull(moduleInfo)) {
//            if (Objects.isNull(fields) || fields.isEmpty()) {
//                return wotApiURIUtils.getApiResponseMap(moduleInfo.getTopModuleUrl()).getData().get(String.valueOf(moduleInfo.getTankId()));
//            } else if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
//                String urlWithFields = moduleInfo.getTopModuleUrl() + "&fields=" + fields.stream().collect(Collectors.joining(","));
//                return wotApiURIUtils.getApiResponseMap(urlWithFields).getData().get(String.valueOf(moduleInfo.getTankId()));
//            } else {
//                WotMap<String, Object> params = new HashMap<>();
//                params.put(FIELDS_PARAM, fields);
//                params.put(TANK_ID_PARAM, moduleInfo.getTankId());
//                VehicleModuleComponent topModuleComponent = moduleInfo.getTopModules();
//                if(Objects.nonNull(topModuleComponent.getEngineId())) {
//                    params.put(ENGINE_ID_PARAM, topModuleComponent.getEngineId());
//                }
//                if(Objects.nonNull(topModuleComponent.getGunId())) {
//                    params.put(GUN_ID_PARAM, topModuleComponent.getGunId());
//                }
//                if(Objects.nonNull(topModuleComponent.getSuspensionId())) {
//                    params.put(SUSPENSION_ID_PARAM, topModuleComponent.getSuspensionId());
//                }
//                if(Objects.nonNull(topModuleComponent.getRadioId())) {
//                    params.put(RADIO_ID_PARAM, topModuleComponent.getRadioId());
//                }
//                if(Objects.nonNull(topModuleComponent.getTurretId())) {
//                    params.put(TURRET_ID_PARAM, topModuleComponent.getTurretId());
//                }
//                return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(moduleInfo.getTankId()));
//            }
//        }
        return null;
    }

    private VehicleCharacteristic getVehicleObject(long tankId) {
        Optional<VehicleCharacteristic> vehicleProfile = wotApiURIUtils.getVehicleProfile(tankId);
        return vehicleProfile.orElse(null);
    }

    private VehicleCharacteristic getVehicleObject(long tankId, List<String> fields) {
        //TODO
//        WotMap<String, Object> params = new HashMap<>();
//        params.put(TANK_ID_PARAM, tankId);
//        params.put(FIELDS_PARAM, fields);
//        return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(tankId));
        return null;
    }
}
