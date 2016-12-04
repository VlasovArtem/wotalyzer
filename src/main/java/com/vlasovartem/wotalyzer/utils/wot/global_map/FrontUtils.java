package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Front;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.FrontConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FRONT_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class FrontUtils extends MainUtils<Front> {

    public List<Front> getFronts() {
        APIResponse<List<Front>> apiResponseList = getApiResponseList("");
        Optional<List<Front>> content = apiResponseList.getContent();
        if (content.isPresent()) {
            return content.get();
        }
        return Collections.emptyList();
    }

    public Optional<Front> getnFrond(int frontId) {
        APIResponse<Front> apiResponse = getApiResponse(newBuilder().customParam(FRONT_ID_PARAM, frontId).build());
        return apiResponse.getContent();
    }

    @Override
    protected Class<Front> getType() {
        return Front.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return FrontConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return FrontConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return FrontConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(MainValidator.validatePageNoParameter(), MainValidator.validateLimit(0, 100, 100));
    }
}
