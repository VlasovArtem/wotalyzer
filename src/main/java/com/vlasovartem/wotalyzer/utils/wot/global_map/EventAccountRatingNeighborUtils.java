package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountRatingNeighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountRatingNeighborUtils extends MainUtils<EventAccountRatingNeighbor> {

    public List<EventAccountRatingNeighbor> getEventAccountRatingNeighbors(long accountId, String eventId, String frontId) {
        APIResponse<List<EventAccountRatingNeighbor>> apiResponse = getApiResponseList(newBuilder()
                .withEventId(eventId)
                .withFrontId(frontId)
                .customParam(ACCOUNT_ID_PARAM, accountId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventAccountRatingNeighbor> getType() {
        return EventAccountRatingNeighbor.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventAccountRatingNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventAccountRatingNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventAccountRatingNeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(10, 100, 10),
                validateIntParameter(1, 99, 3, WOTAPIConstants.NEIGHBOURS_COUNT_PARAM),
                validatePageNoParameter());
    }

}
