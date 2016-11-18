package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.Event;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventUtils extends MainUtils<Event> {

    @Override
    protected Class getType() {
        return Event.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return EventConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(MainValidator.validatePageNoParameter(), MainValidator.validateLimit(1, 20, 5), GlobalMapValidator.validateStatusParameter());
    }
}
