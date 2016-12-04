package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountInfoConstants;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountInfoUtils extends MainUtils<EventAccountInfo> {

    public List<EventAccountInfo> getEventsAccountInfo(long accountId, String eventId, String frontId) {
        APIResponse<List<EventAccountInfo>> apiResponse = getApiResponseList(newBuilder()
                .withEventId(eventId)
                .withFrontId(frontId)
                .customParam(ACCOUNT_ID_PARAM, accountId)
                .build());
        Optional<List<EventAccountInfo>> content = apiResponse.getContent();
        return content.orElse(Collections.emptyList());
    }
    @Override
    protected Class<EventAccountInfo> getType() {
        return EventAccountInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventAccountInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventAccountInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventAccountInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateFrontIdParameter());
    }

}
