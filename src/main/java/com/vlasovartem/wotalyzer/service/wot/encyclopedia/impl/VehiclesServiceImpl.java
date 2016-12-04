package com.vlasovartem.wotalyzer.service.wot.encyclopedia.impl;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.service.wot.encyclopedia.VehiclesService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;
import com.vlasovartem.wotalyzer.utils.wot.encyclopedia.VehicleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FIELDS_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TIER_PARAM;

/**
 * Created by artemvlasov on 14/01/16.
 */
@Service
public class VehiclesServiceImpl implements VehiclesService {

    private TankUtils tankUtils;
    private VehicleUtils vehiclesUtils;

    @Autowired
    public VehiclesServiceImpl(TankUtils tankUtils, VehicleUtils vehiclesUtils) {
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
    public Vehicle findById(long id, List<String> fields) {
        return getVehicleBaseInfoObject(id, fields);
    }

    @Override
    public List<Vehicle> findByTierAndType(Integer tier, VehicleType type, List<String> requiredFields) {
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
        //TODO
//        WotMap<String, Vehicle> tierVehicles = vehiclesUtils.getApiResponseMap(param).getData();
//        return tierVehicles.entrySet().stream()
//                .map(WotMap.Entry::getValue)
//                .filter(vbi -> type.getName().equals(vbi.getType()))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Vehicle> findByTierAndType(Integer tier, List<String> requiredFields) {
        return findByTierAndType(tier, null, requiredFields);
    }

    @Override
    public List<Vehicle> findByTierAndType(VehicleType type, List<String> requiredFields) {
        return findByTierAndType(null, type, requiredFields);
    }

    @Override
    public List<Vehicle> findByTierAndType(List<String> requiredFields) {
        return findByTierAndType(null, null, requiredFields);
    }

    @Override
    public List<Vehicle> findAll(List<String> fields) {
        //TODO
        /*WotMap<String, Object> params = new HashMap<>();
        params.put(FIELDS_PARAM, fields);
        return vehiclesUtils.getApiResponseMap(params)
                .getData().entrySet().stream()
                .map(WotMap.Entry::getValue).collect(Collectors.toList());*/
        return null;
    }

    private Vehicle getVehicleBaseInfoObject(long tankId) {
        //TODO
//        List<Vehicle> vehicles = vehiclesUtils.getVehiclesApiResponse(tankId)
//                .getData()
//                .get(String.valueOf(tankId));
//        if (!vehicles.isEmpty()) {
//            return vehicles.get(0);
//        }
        return null;
    }
    private Vehicle getVehicleBaseInfoObject(long tankId, List<String> fields) {
        //TODO
//        WotMap<String, Object> params = new HashMap<>();
//        params.put(TANK_ID_PARAM, tankId);
//        params.put(FIELDS_PARAM, fields);
//        return vehiclesUtils.getApiResponseMap(params).getData().get(String.valueOf(tankId));
        return null;
    }
}
