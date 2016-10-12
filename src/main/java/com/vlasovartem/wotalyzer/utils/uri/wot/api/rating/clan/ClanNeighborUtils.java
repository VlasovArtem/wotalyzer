package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanNeighborUtils extends MainUtils<ClanNeighbor> {

    public ClanNeighborUtils() {
        super(ClanNeighbor.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanNeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        int limit = (int) entrySet.getValue();
                        queryParams.replace(LIMIT_PARAM, RatingValidator.validateLimitWithMax(limit, 50, 5));
                        break;
                }
            }
        }
        return true;
    }
}
