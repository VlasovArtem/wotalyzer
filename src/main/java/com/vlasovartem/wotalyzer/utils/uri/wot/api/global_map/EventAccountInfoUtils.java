package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.EventAccountInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.EventAccountInfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FRONT_ID_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountInfoUtils extends MainUtils<EventAccountInfo> {

    public EventAccountInfoUtils() {
        super(EventAccountInfo.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return EventAccountInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return EventAccountInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return EventAccountInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case FRONT_ID_PARAM:
                        boolean b = GlobalMapValidator.validateFrontIdParameter(entrySet.getValue());
                        if (!b)
                            return false;
                        break;
                }
            }
        }
        return true;
    }
}
