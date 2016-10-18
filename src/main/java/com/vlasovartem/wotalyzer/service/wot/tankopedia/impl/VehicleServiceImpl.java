package com.vlasovartem.wotalyzer.service.wot.tankopedia.impl;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleComponent;
import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.service.wot.tankopedia.VehicleService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia.VehicleProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

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
                    params.put(TANK_ID_PARAM, id);
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
        return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(params.get(TANK_ID_PARAM)));
    }

    @Override
    public VehicleProfile getVehicle(VehicleModuleInfo moduleInfo, List<String> fields) {
        if(Objects.nonNull(moduleInfo)) {
            if (Objects.isNull(fields) || fields.isEmpty()) {
                return wotApiURIUtils.getApiResponseMap(moduleInfo.getTopModuleUrl()).getData().get(String.valueOf(moduleInfo.getTankId()));
            } else if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
                String urlWithFields = moduleInfo.getTopModuleUrl() + "&fields=" + fields.stream().collect(Collectors.joining(","));
                return wotApiURIUtils.getApiResponseMap(urlWithFields).getData().get(String.valueOf(moduleInfo.getTankId()));
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put(FIELDS_PARAM, fields);
                params.put(TANK_ID_PARAM, moduleInfo.getTankId());
                VehicleModuleComponent topModuleComponent = moduleInfo.getTopModules();
                if(Objects.nonNull(topModuleComponent.getEngineId())) {
                    params.put(ENGINE_ID_PARAM, topModuleComponent.getEngineId());
                }
                if(Objects.nonNull(topModuleComponent.getGunId())) {
                    params.put(GUN_ID_PARAM, topModuleComponent.getGunId());
                }
                if(Objects.nonNull(topModuleComponent.getSuspensionId())) {
                    params.put(SUSPENSION_ID_PARAM, topModuleComponent.getSuspensionId());
                }
                if(Objects.nonNull(topModuleComponent.getRadioId())) {
                    params.put(RADIO_ID_PARAM, topModuleComponent.getRadioId());
                }
                if(Objects.nonNull(topModuleComponent.getTurretId())) {
                    params.put(TURRET_ID_PARAM, topModuleComponent.getTurretId());
                }
                return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(moduleInfo.getTankId()));
            }
        }
        return null;
    }

    private VehicleProfile getVehicleObject(long tankId) {
        return wotApiURIUtils.getVehicleApiResponse(tankId).getData().get(String.valueOf(tankId));
    }

    private VehicleProfile getVehicleObject(long tankId, List<String> fields) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        params.put(FIELDS_PARAM, fields);
        return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(tankId));
    }
}
