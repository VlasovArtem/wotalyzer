package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.APIResponse;
import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.Vehicles;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.VehiclesConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.VehicleBasicConstants.TANK_ID_PARAM;

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
     * @param <U> type of the object
     * @return APIResponse with associated array.
     */
    public APIResponse<Map<String, Vehicles>> getVehiclesApiResponse(long tankId) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        return getApiResponse(params);
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
}
