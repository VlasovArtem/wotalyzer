package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanProvince;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanProvinceConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanProvinceUtils extends MainUtils<ClanProvince> {

    public List<ClanProvince> getClanProvinces(int clanId) {
        APIResponse<Map<String, List<ClanProvince>>> apiResponse = getApiResponseMapList(ClanParamBuilder.newBuilder().withClanId(clanId).build());
        Optional<Map<String, List<ClanProvince>>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return content.get().get(String.valueOf(clanId));
        }
        return Collections.emptyList();
    }

    @Override
    protected Class<ClanProvince> getType() {
        return ClanProvince.class;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateClanIDParameter());
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanProvinceConstants.getInstance();
    }
}
