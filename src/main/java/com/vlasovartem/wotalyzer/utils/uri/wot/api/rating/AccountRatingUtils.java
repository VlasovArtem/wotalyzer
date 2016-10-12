package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.AccountRating;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountRatingConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class AccountRatingUtils extends RatingUtils<AccountRating> {

    private static final Logger LOGGER = LogManager.getLogger(AccountRatingUtils.class);

    public AccountRatingUtils() {
        super(AccountRating.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case BATTLE_TYPE_PARAM:
                        queryParams.replace(BATTLE_TYPE_PARAM, validateBattleType(entrySet));
                        break;
                    case DATE_PARAM:
                        queryParams.replace(DATE_PARAM, validateDate(entrySet));
                        break;
                }
            }
        }
        return false;
    }

}
