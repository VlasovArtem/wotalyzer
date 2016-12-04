package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonClanInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonClanInfoUtils extends MainUtils<SeasonClanInfo> {

    public Optional<SeasonClanInfo> getClansSeasonInfo(int clanId, String seasonId, int vehicleLevel) {
        APIResponse<SeasonClanInfo> apiResponse = getApiResponse(newBuilder()
                .withClanId(clanId)
                .withSeasonId(seasonId)
                .withVehicleLevel(vehicleLevel).build());
        return apiResponse.getContent();
    }

    @Override
    protected Class<SeasonClanInfo> getType() {
        return SeasonClanInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonClanInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonClanInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonClanInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateVehicleLevelParameter());
    }
}
