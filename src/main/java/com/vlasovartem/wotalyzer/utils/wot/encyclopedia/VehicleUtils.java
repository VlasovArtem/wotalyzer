package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.VehicleType;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleConstants;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TIER_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 07/10/16.
 */
@Component
public class VehicleUtils extends MainUtils<Vehicle> {

    public List<Vehicle> getVehicles(int tier) {
        return convertMapToList(getApiResponseMap(newBuilder().customParam(TIER_PARAM, tier).build()));
    }

    public Optional<Vehicle> getVehicle(int tankId) {
        APIResponse<Vehicle> apiResponse = getApiResponse(newBuilder().customParam(TANK_ID_PARAM, tankId).build());
        return apiResponse.getContent();
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        return convertMapToList(getApiResponseMap(newBuilder().customParam(TYPE_PARAM, type.getValue()).build()));
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
    public String getAPIBaseUrl() {
        return VehicleConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateVehiclesTypeParameter());
    }
}
