package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.Event;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventUtils extends MainUtils<Event> {

    public List<Event> getEvents() {
        APIResponse<List<Event>> apiResponse = getApiResponseList("");
        return apiResponse.getContent().orElse(Collections.emptyList());
    }

    public Optional<Event> getEvent(String eventId) {
        APIResponse<List<Event>> apiResponse = getApiResponseList(ClanParamBuilder.newBuilder().withEventId(eventId).build());
        Optional<List<Event>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return content.get().stream().findFirst();
        }
        return Optional.empty();
    }

    @Override
    protected Class<Event> getType() {
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
