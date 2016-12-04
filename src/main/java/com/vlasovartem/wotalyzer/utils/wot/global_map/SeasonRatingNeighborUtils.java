package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonRatingNeighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateVehicleLevelParameter;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonRatingNeighborUtils extends MainUtils<SeasonRatingNeighbor> {

    public List<SeasonRatingNeighbor> seasonRatingNeighbors(int clanId, String seasonId, int vehicleLevel) {
        APIResponse<List<SeasonRatingNeighbor>> apiResponse = getApiResponseList(newBuilder()
                .withClanId(clanId)
                .withSeasonId(seasonId)
                .withVehicleLevel(vehicleLevel)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<SeasonRatingNeighbor> getType() {
        return SeasonRatingNeighbor.class;
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
