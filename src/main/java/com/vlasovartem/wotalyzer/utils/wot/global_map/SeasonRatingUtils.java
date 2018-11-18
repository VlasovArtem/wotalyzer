package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonRating;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonRatingConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateVehicleLevelParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonRatingUtils extends MainUtils<SeasonRating> {

    public List<SeasonRating> getSeasonRatings(String seasonId, int vehicleLevel) {
        APIResponse<List<SeasonRating>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder()
                .withSeasonId(seasonId)
                .withVehicleLevel(vehicleLevel)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<SeasonRating> getType() {
        return SeasonRating.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return SeasonRatingConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePageNoParameter(), validateLimit(1, 100, 10), validateVehicleLevelParameter());
    }
}
