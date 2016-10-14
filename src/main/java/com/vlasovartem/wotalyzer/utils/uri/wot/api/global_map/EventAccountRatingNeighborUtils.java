package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountRatingNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.NEIGHBOURS_COUNT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.PAGE_NO_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountRatingNeighborUtils extends MainUtils<EventAccountRatingNeighbor> {

    public EventAccountRatingNeighborUtils() {
        super(EventAccountRatingNeighbor.class);
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
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        queryParams.replace(LIMIT_PARAM, MainValidator.validateLimit((Integer) entrySet.getValue(), 10, 100, 10));
                        break;
                    case NEIGHBOURS_COUNT_PARAM:
                        queryParams.replace(NEIGHBOURS_COUNT_PARAM, MainValidator.validateLimit((Integer) entrySet.getValue(), 1, 99, 3));
                        break;
                    case PAGE_NO_PARAM:
                        queryParams.replace(PAGE_NO_PARAM, MainValidator.validateLimitWithMin((Integer) entrySet.getValue(), 1, 1));
                }
            }
        }
        return true;
    }
}
