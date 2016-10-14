package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.TopClan;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.TopClanConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class TopClanUtils extends MainUtils<TopClan> {

    public TopClanUtils() {
        super(TopClan.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return TopClanConstants.BASIC_URL;
}

    @Override
    public List<String> getAPIConstants() {
        return TopClanConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TopClanConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        int limit = (int) entrySet.getValue();
                        queryParams.replace(LIMIT_PARAM, MainValidator.validateLimitWithMax(limit, 1000, 10));
                        break;
                }
            }
        }
        return true;
    }
}
