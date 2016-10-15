package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountRatingConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventAccountRatingUtils extends MainUtils<EventAccountRating> {

    public EventAccountRatingUtils() {
        super(EventAccountRating.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return EventAccountRatingConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventAccountRatingConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventAccountRatingConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePageNoParameter(), validateLimit(10, 100, 20), GlobalMapValidator.validateInRatingParameter());
    }
}
