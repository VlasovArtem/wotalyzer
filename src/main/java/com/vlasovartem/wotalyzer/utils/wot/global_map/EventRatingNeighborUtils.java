package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventRatingNeighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventRatingNeighborUtils extends MainUtils<EventRatingNeighbor> {

    public List<EventRatingNeighbor> getEventRatingNeighbors(int clanId, String eventId, String frontId) {
        APIResponse<List<EventRatingNeighbor>> apiResponse = getApiResponseList(newBuilder()
                .withClanId(clanId)
                .withEventId(eventId)
                .withFrontId(frontId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventRatingNeighbor> getType() {
        return EventRatingNeighbor.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventRatingNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventRatingNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventRatingNeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimit(1, 99, 10));
    }

}
