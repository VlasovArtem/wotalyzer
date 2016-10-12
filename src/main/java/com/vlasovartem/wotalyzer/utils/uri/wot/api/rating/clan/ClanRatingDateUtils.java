package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanRatingDateConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingDateUtils extends MainUtils<ClanRatingDate> {

    public ClanRatingDateUtils() {
        super(ClanRatingDate.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanRatingDateConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanRatingDateConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanRatingDateConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        int limit = (int) entrySet.getValue();
                        queryParams.replace(LIMIT_PARAM, RatingValidator.validateLimitWithMax(limit, 365, 7));
                        break;
                }
            }
        }
        return true;
    }

}
