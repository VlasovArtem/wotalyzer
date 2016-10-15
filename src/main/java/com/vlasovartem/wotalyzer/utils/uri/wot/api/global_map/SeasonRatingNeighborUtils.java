package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonRatingNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateVehicleLevelParameter;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonRatingNeighborUtils extends MainUtils<SeasonRatingNeighbor> {

    public SeasonRatingNeighborUtils() {
        super(SeasonRatingNeighbor.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonRatingNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonRatingNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonRatingNeighborConstants.REQUIRED_PARAMS;
    }



    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateVehicleLevelParameter(), MainValidator.validateLimit(1, 99, 10));
    }
}
