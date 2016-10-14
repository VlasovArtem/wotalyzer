package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayersConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.SEARCH_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlayersUtils extends MainUtils<Players> {

    public PlayersUtils() {
        super(Players.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return PlayersConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlayersConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlayersConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if (checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case SEARCH_PARAM:
                        return AccountValidator.validateSearchParameter((String) entrySet.getValue());
                    case LIMIT_PARAM:
                        queryParams.replace(LIMIT_PARAM, MainValidator.validateLimit((Integer) entrySet.getValue(), 0, 100, 100));
                        break;
                    case TYPE_PARAM:
                        String searchValue = (String) queryParams.get(SEARCH_PARAM);
                        if (!AccountValidator.validateTypeParameter(queryParams) && searchValue.length() > 2) {
                            queryParams.replace(TYPE_PARAM, "startwith");
                        } else {
                            return false;
                        }
                }
            }
        }
        return true;
    }
}
