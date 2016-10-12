package com.vlasovartem.wotalyzer.service.wot.tankopedia.impl;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleComponent;
import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.service.wot.tankopedia.VehicleService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.VehicleBasicConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.VehicleProfileConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia.VehicleProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private TankUtils tankUtils;
    private VehicleProfileUtils wotApiURIUtils;

    @Autowired
    public VehicleServiceImpl(TankUtils tankUtils, VehicleProfileUtils wotApiURIUtils) {
        this.tankUtils = tankUtils;
        this.wotApiURIUtils = wotApiURIUtils;
    }

//    @Override
    public List<VehicleProfile> getVehicles(List<Long> tankIds) {
        return tankIds.stream().map(this::getVehicle).collect(Collectors.toList());
    }

    @Override
    public List<VehicleProfile> getVehicles(List<Long> tankIds, List<String> requiredFields) {
        return tankIds.stream().map(id -> getVehicle(id, requiredFields)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleProfile> getVehicles(List<Long> tankIds, Map<String, Object> params) {
        return tankIds.stream()
                .map(id -> {
                    params.put(VehicleBasicConstants.TANK_ID_PARAM, id);
                    return params;
                })
                .map(this::getVehicle)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleProfile getVehicle(long tankId) {
        return getVehicleObject(tankId);
    }

    @Override
    public VehicleProfile getVehicle(long tankId, List<String> requiredFields) {
        return getVehicleObject(tankId, requiredFields);
    }

    @Override
    public VehicleProfile getVehicle(Map<String, Object> params) {
        return wotApiURIUtils.getApiResponse(params).getData().get(String.valueOf(params.get(VehicleBasicConstants.TANK_ID_PARAM)));
    }

    @Override
    public VehicleProfile getVehicle(VehicleModuleInfo moduleInfo, List<String> fields) {
        if(Objects.nonNull(moduleInfo)) {
            if (Objects.isNull(fields) || fields.isEmpty()) {
                return wotApiURIUtils.getApiResponse(moduleInfo.getTopModuleUrl()).getData().get(String.valueOf(moduleInfo.getTankId()));
            } else if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
                String urlWithFields = moduleInfo.getTopModuleUrl() + "&fields=" + fields.stream().collect(Collectors.joining(","));
                return wotApiURIUtils.getApiResponse(urlWithFields).getData().get(String.valueOf(moduleInfo.getTankId()));
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put(BasicAPIConstants.FIELDS_PARAM, fields);
                params.put(VehicleBasicConstants.TANK_ID_PARAM, moduleInfo.getTankId());
                VehicleModuleComponent topModuleComponent = moduleInfo.getTopModules();
                if(Objects.nonNull(topModuleComponent.getEngineId())) {
                    params.put(VehicleProfileConstants.ENGINE_ID_PARAM, topModuleComponent.getEngineId());
                }
                if(Objects.nonNull(topModuleComponent.getGunId())) {
                    params.put(VehicleProfileConstants.GUN_ID_PARAM, topModuleComponent.getGunId());
                }
                if(Objects.nonNull(topModuleComponent.getSuspensionId())) {
                    params.put(VehicleProfileConstants.SUSPENSION_ID_PARAM, topModuleComponent.getSuspensionId());
                }
                if(Objects.nonNull(topModuleComponent.getRadioId())) {
                    params.put(VehicleProfileConstants.RADIO_ID_PARAM, topModuleComponent.getRadioId());
                }
                if(Objects.nonNull(topModuleComponent.getTurretId())) {
                    params.put(VehicleProfileConstants.TURRET_ID_PARAM, topModuleComponent.getTurretId());
                }
                return wotApiURIUtils.getApiResponse(params).getData().get(String.valueOf(moduleInfo.getTankId()));
            }
        }
        return null;
    }

    private VehicleProfile getVehicleObject(long tankId) {
        return wotApiURIUtils.getVehicleApiResponse(tankId).getData().get(String.valueOf(tankId));
    }

    private VehicleProfile getVehicleObject(long tankId, List<String> fields) {
        Map<String, Object> params = new HashMap<>();
        params.put(VehicleBasicConstants.TANK_ID_PARAM, tankId);
        params.put(BasicAPIConstants.FIELDS_PARAM, fields);
        return wotApiURIUtils.getApiResponse(params).getData().get(String.valueOf(tankId));
    }
}
