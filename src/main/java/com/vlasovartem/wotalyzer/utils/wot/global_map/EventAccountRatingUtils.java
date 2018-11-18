package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountRating;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountRatingConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventAccountRatingUtils extends MainUtils<EventAccountRating> {

    public List<EventAccountRating> getEventAccountRatings(String eventId, String frontId) {
        APIResponse<List<EventAccountRating>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder()
                .withEventId(eventId)
                .withFrontId(frontId)
                .build());
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<EventAccountRating> getType() {
        return EventAccountRating.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return EventAccountRatingConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePageNoParameter(), validateLimit(10, 100, 20), GlobalMapValidator.validateInRatingParameter());
    }
}
