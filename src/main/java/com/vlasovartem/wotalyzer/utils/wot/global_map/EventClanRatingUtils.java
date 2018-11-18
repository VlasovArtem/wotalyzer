package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventClanRating;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventClanRatingConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventClanRatingUtils extends MainUtils<EventClanRating> {

    public List<EventClanRating> getEventRatings(String eventId, String frontId) {
        APIResponse<List<EventClanRating>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder()
                .withEventId(eventId)
                .withFrontId(frontId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventClanRating> getType() {
        return EventClanRating.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return EventClanRatingConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(MainValidator.validatePageNoParameter(), MainValidator.validateLimit(1, 100, 10));
    }
}
