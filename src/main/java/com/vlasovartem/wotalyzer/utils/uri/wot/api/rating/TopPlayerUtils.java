package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.TopPlayer;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.TopPlayerConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateBattleType;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateDate;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TopPlayerUtils extends RatingUtils<TopPlayer> {

    public TopPlayerUtils() {
        super(TopPlayer.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return TopPlayerConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TopPlayerConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TopPlayerConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case BATTLE_TYPE_PARAM:
                        queryParams.replace(BATTLE_TYPE_PARAM, validateBattleType(entrySet, getBattleTypes()));
                        break;
                    case DATE_PARAM:
                        queryParams.replace(DATE_PARAM, validateDate(entrySet));
                        break;
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
