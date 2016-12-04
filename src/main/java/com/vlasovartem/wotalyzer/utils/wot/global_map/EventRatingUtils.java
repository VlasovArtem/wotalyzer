package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventRating;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventRatingConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventRatingUtils extends MainUtils<EventRating> {

    public List<EventRating> getEventRatings(String eventId, String frontId) {
        APIResponse<List<EventRating>> apiResponse = getApiResponseList(newBuilder()
                .withEventId(eventId)
                .withFrontId(frontId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventRating> getType() {
        return EventRating.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventRatingConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventRatingConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventRatingConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(MainValidator.validatePageNoParameter(), MainValidator.validateLimit(1, 100, 10));
    }
}
