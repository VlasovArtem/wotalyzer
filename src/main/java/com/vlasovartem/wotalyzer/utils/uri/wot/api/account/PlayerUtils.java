package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by artemvlasov on 06/10/16.
 */
@Component
public class PlayerUtils extends MainUtils<Player> {

    public PlayerUtils() {
        super(Player.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return PlayerConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlayerConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlayerConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if (checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case WOTAPIConstants.EXTRA_PARAM:
                        if (!AccountValidator.validateExtraParameter((String) entrySet.getValue())) {
                            return false;
                        }
                }
            }
        }
        return true;
    }
}
