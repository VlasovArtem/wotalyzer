package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanInfoUtils extends MainUtils<ClanInfo> {

    public Optional<ClanInfo> getClanInfo(int clanId) {
        APIResponse<ClanInfo> apiResponse = getApiResponse(newBuilder().withClanId(clanId).build());
        return apiResponse.getContent();
    }

    @Override
    protected Class<ClanInfo> getType() {
        return ClanInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanInfoConstants.REQUIRED_PARAMS;
    }
}
