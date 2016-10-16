package com.vlasovartem.wotalyzer.service.wot.tankopedia.impl;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicles;
import com.vlasovartem.wotalyzer.service.wot.tankopedia.VehiclesService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia.VehiclesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Service
public class VehiclesServiceImpl implements VehiclesService {

    private TankUtils tankUtils;
    private VehiclesUtils vehiclesUtils;

    @Autowired
    public VehiclesServiceImpl(TankUtils tankUtils, VehiclesUtils vehiclesUtils) {
        this.tankUtils = tankUtils;
        this.vehiclesUtils = vehiclesUtils;
    }

    @Override
    public String getVehicleType(long tankId) {
        return getVehicleBaseInfoObject(tankId, Collections.singletonList("type")).getType();
    }

    @Override
    public int getVehicleTier(long tankId) {
        return getVehicleBaseInfoObject(tankId, Collections.singletonList("tier")).getTier();
    }

    @Override
    public boolean isPremium(long tankId) {
        return getVehicleBaseInfoObject(tankId, Collections.singletonList("is_premium")).isPremium();
    }

    @Override
    public Vehicles findById(long id, List<String> fields) {
        return getVehicleBaseInfoObject(id, fields);
    }

    @Override
    public List<Vehicles> findByTierAndType(Integer tier, VehicleType type, List<String> requiredFields) {
        Map<String, Object> param = new HashMap<>();
        if(Objects.nonNull(tier)) {
            param.put(TIER_PARAM, tier);
        }
        if(Objects.nonNull(type)) {
            if (Objects.nonNull(requiredFields) && !requiredFields.isEmpty()) {
                List<String> fields = new ArrayList<>(requiredFields);
                if (!fields.contains("type")) {
                    fields.add("type");
                }
                param.put(FIELDS_PARAM, fields);
            }
        }
        Map<String, Vehicles> tierVehicles = vehiclesUtils.getApiResponse(param).getData();
        return tierVehicles.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(vbi -> type.getName().equals(vbi.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicles> findByTierAndType(Integer tier, List<String> requiredFields) {
        return findByTierAndType(tier, null, requiredFields);
    }

    @Override
    public List<Vehicles> findByTierAndType(VehicleType type, List<String> requiredFields) {
        return findByTierAndType(null, type, requiredFields);
    }

    @Override
    public List<Vehicles> findByTierAndType(List<String> requiredFields) {
        return findByTierAndType(null, null, requiredFields);
    }

    @Override
    public List<Vehicles> findAll(List<String> fields) {
        Map<String, Object> params = new HashMap<>();
        params.put(FIELDS_PARAM, fields);
        return vehiclesUtils.getApiResponse(params)
                .getData().entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private Vehicles getVehicleBaseInfoObject(long tankId) {
        return vehiclesUtils.getVehiclesApiResponse(tankId).getData().get(String.valueOf(tankId));
    }
    private Vehicles getVehicleBaseInfoObject(long tankId, List<String> fields) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        params.put(FIELDS_PARAM, fields);
        return vehiclesUtils.getApiResponse(params).getData().get(String.valueOf(tankId));
    }
}
