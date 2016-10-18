package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.APIResponse;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicles;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehiclesConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Created by artemvlasov on 07/10/16.
 */
@Component
public class VehiclesUtils extends MainUtils<Vehicles> {

    public VehiclesUtils() {
        super(Vehicles.class);
    }

    /**
     * Find VehicleUtils with single parameter tank id
     * @param tankId tank id
     * @return APIResponse with associated array.
     */
    public APIResponse<Map<String, Vehicles>> getVehiclesApiResponse(long tankId) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        return getApiResponseMap(params);
    }

    @Override
    public String getAPIBaseUrl() {
        return VehiclesConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehiclesConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehiclesConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateVehiclesTypeParameter());
    }
}
