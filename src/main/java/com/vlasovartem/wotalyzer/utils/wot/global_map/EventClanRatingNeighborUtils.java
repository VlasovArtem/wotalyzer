package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventClanRatingNeighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventClanRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventClanRatingNeighborUtils extends MainUtils<EventClanRatingNeighbor> {

    public List<EventClanRatingNeighbor> getEventRatingNeighbors(int clanId, String eventId, String frontId) {
        APIResponse<List<EventClanRatingNeighbor>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder()
                .withClanId(clanId)
                .withEventId(eventId)
                .withFrontId(frontId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventClanRatingNeighbor> getType() {
        return EventClanRatingNeighbor.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return EventClanRatingNeighborConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimit(1, 99, 10));
    }

}
