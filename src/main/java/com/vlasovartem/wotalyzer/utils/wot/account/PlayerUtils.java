package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerConstants;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.AccountParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 06/10/16.
 */
@Component
public class PlayerUtils extends MainUtils<Player> {

    @Override
    protected Class<Player> getType() {
        return Player.class;
    }

    public Optional<Player> getPlayer(long accountId) {
        return APIResponseUtils.convertMapToObject(getApiResponseMap(newBuilder().withAccountId(accountId).build()));
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
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(AccountValidator.validateExtraParameter());
    }

}
