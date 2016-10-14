package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventRatingNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

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
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        queryParams.replace(LIMIT_PARAM, MainValidator.validateLimit((Integer) entrySet.getValue(), 1, 99, 10));
                        break;
                }
            }
        }
        return true;
    }
}
