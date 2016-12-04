package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonAccountInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonAccountInfoConstants;
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
 * https://developers.wargaming.net/reference/all/wot/globalmap/seasonaccountinfo/
 */
public class SeasonAccountInfoUtils extends MainUtils<SeasonAccountInfo> {

    public Optional<SeasonAccountInfo> getSeasonAccountInfo(int accountId, String seasonId, int vehicleLevel) {
        APIResponse<SeasonAccountInfo> apiResponse = getApiResponse(newBuilder()
                .withSeasonId(seasonId)
                .withVehicleLevel(vehicleLevel)
                .customParam(WOTAPIConstants.ACCOUNT_ID_PARAM, accountId)
                .build());
        return apiResponse.getContent();
    }

    @Override
    protected Class<SeasonAccountInfo> getType() {
        return SeasonAccountInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonAccountInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonAccountInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonAccountInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateVehicleLevelParameter());
    }

}
