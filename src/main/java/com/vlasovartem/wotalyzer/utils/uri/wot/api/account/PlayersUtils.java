package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayersConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
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
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
            return Arrays.asList(AccountValidator.validateSearchParameter(), MainValidator.validateLimit(0, 100, 100), AccountValidator.validateTypeParameter());
    }
}
