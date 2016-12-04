package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Province;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ProvinceConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ProvinceUtils extends MainUtils<Province> {

    public List<Province> getProvinces(String frontId) {
        APIResponse<List<Province>> apiResponseList = getApiResponseList(newBuilder().withFrontId(frontId).build());
        Optional<List<Province>> content = apiResponseList.getContent();
        if (content.isPresent()) {
            return content.get();
        }
        return Collections.emptyList();
    }

    @Override
    protected Class<Province> getType() {
        return Province.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ProvinceConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ProvinceConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ProvinceConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePrimeHourParameter(), validatePageNoParameter(), validateOrderByParameter(), validateLimit(0, 100, 100), validateLandingTypeParameter());
    }
}
