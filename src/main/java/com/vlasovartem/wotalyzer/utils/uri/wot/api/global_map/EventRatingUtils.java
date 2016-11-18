package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventRatingConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventRatingUtils extends MainUtils<EventRating> {

    @Override
    protected Class getType() {
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
