package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventRatingNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventRatingNeighborUtils extends MainUtils<EventRatingNeighbor> {

    public EventRatingNeighborUtils() {
        super(EventRatingNeighbor.class);
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
