package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Optional;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanInfoUtils extends MainUtils<ClanInfo> {

    public Optional<ClanInfo> getClanInfo(int clanId) {
        APIResponse<ClanInfo> apiResponse = getApiResponse(ClanParamBuilder.newBuilder().withClanId(clanId).build());
        return apiResponse.getContent();
    }

    @Override
    protected Class<ClanInfo> getType() {
        return ClanInfo.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanInfoConstants.getInstance();
    }
}
