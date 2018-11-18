package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountRatingNeighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountRatingNeighborUtils extends MainUtils<EventAccountRatingNeighbor> {

    public List<EventAccountRatingNeighbor> getEventAccountRatingNeighbors(long accountId, String eventId, String frontId) {
        APIResponse<List<EventAccountRatingNeighbor>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder()
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
    protected BasicAPIConstants getAPIConstants() {
        return EventAccountRatingNeighborConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(10, 100, 10),
                validateIntParameter(1, 99, 3, WOTAPIConstants.NEIGHBOURS_COUNT_PARAM),
                validatePageNoParameter());
    }

}
