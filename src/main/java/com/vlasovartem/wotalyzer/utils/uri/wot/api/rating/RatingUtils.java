package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountRatingConstants.BATTLE_TYPE_PARAM;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public abstract class RatingUtils<T> extends MainUtils<T> {

    private static final Logger LOGGER = LogManager.getLogger(RatingUtils.class);
    private List<String> battleTypes;

    RatingUtils(Class<T> type) {
        super(type);
        battleTypes = Arrays.asList("company", "random", "team", "default");
    }

    public List<String> getBattleTypes() {
        return battleTypes;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case BATTLE_TYPE_PARAM:
                        queryParams.replace(BATTLE_TYPE_PARAM, RatingValidator.validateBattleType(entrySet, getBattleTypes()));
                        break;
                }
            }
        }
        return true;
    }


}
