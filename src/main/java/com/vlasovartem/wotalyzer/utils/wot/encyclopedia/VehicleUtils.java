package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.VehicleType;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 07/10/16.
 */
@Component
public class VehicleUtils extends MainUtils<Vehicle> {

    public Optional<Vehicle> getVehicle(long tankId) {
        APIResponse<Map<String, Vehicle>> apiResponse = getApiResponseMap(VehicleParamBuilder.newBuilder().withTankId(tankId).build());
        return convertMapToObject(apiResponse);
    }

    public List<Vehicle> getVehicles(List<Long> tankIds) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder().withTankIds(tankIds).build()));
    }

    public List<Vehicle> getVehicles(List<Long> tankIds, List<String> fields) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder()
                .withTankIds(tankIds)
                .withFields(fields)
                .build()));
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder().withVehicleType(type).build()));
    }

    public List<Vehicle> getVehicles(Nation nation) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder().withNation(nation).build()));
    }

    public List<Vehicle> getVehicles(int tier) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder().withTier(tier).build()));
    }


    @Override
    protected Class<Vehicle> getType() {
        return Vehicle.class;
    }

    //TODO
//    /**
//     * Find VehicleUtils with single parameter tank id
//     *
//     * @param tankId tank id
//     * @return APIResponse with associated array.
//     */
//    public APIResponseMapList<Vehicle> getVehiclesApiResponse(long tankId) {
//        Map<String, Object> params = new HashMap<>();
//        params.put(TANK_ID_PARAM, tankId);
//        return getApiResponseMapList(params);
//    }
//
//    public APIResponseList<Vehicle> getVehiclesApiResponse(List<Integer> tankIds) {
//        Map<String, Object> build = QueryParamBuilder.newBuilder().customParam(WOTAPIConstants.TANK_ID_PARAM, tankIds.stream()
//                .map(Object::toString)
//                .collect(Collectors.joining(",")))
//                .withFields(Arrays.asList(WOTAPIConstants.TANK_ID_PARAM, WOTAPIConstants.TIER_PARAM))
//                .build();
//        return getApiResponseList(build);
//    }


    @Override
    protected BasicAPIConstants getAPIConstants() {
        return VehicleConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateVehiclesTypeParameter());
    }
}
