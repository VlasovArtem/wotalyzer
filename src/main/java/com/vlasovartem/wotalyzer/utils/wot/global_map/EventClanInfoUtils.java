package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventClanInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventClanInfoUtils extends MainUtils<EventClanInfo> {

    public Optional<EventClanInfo> getEventClanInfo(int clanId, String eventId, String frontId) {
        APIResponse<Map<String, EventClanInfo>> apiResponse = getApiResponseMap(ClanParamBuilder
                .newBuilder()
                .withClanId(clanId)
                .withFrontId(frontId)
                .withEventId(eventId)
                .build());
        Optional<Map<String, EventClanInfo>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return Optional.of(content.get().get(String.valueOf(clanId)));
        }
        return Optional.empty();
    }

    @Override
    protected Class<EventClanInfo> getType() {
        return EventClanInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventClanInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventClanInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventClanInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateFrontIdParameter());
    }
}
