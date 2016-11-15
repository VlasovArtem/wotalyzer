package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseList;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMapList;
import com.vlasovartem.wotalyzer.utils.QueryParamBuilder;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Created by artemvlasov on 07/10/16.
 */
@Component
public class VehicleUtils extends MainUtils<Vehicle> {

    public VehicleUtils() {
        super(Vehicle.class);
    }

    /**
     * Find VehicleUtils with single parameter tank id
     *
     * @param tankId tank id
     * @return AbstractAPIResponse with associated array.
     */
    public APIResponseMapList<Vehicle> getVehiclesApiResponse(long tankId) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        return getApiResponseMapList(params);
    }

    public APIResponseList<Vehicle> getVehiclesApiResponse(List<Integer> tankIds) {
        Map<String, Object> build = QueryParamBuilder.newBuilder().customParam(WOTAPIConstants.TANK_ID_PARAM, tankIds.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")))
                .withFields(Arrays.asList(WOTAPIConstants.TANK_ID_PARAM, WOTAPIConstants.TIER_PARAM))
                .build();
        return getApiResponseList(build);
    }

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
