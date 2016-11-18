package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMap;
import com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by artemvlasov on 06/10/16.
 */
@Component
public class PlayerUtils extends MainUtils<Player> {

    @Override
    protected Class getType() {
        return Player.class;
    }

    public Optional<Player> getPlayer(int accountId) {
        APIResponseMap<Player> player = getApiResponseMap(QueryParamBuilder.newBuilder().withAccountId(accountId).build());
        Optional<Map<String, Player>> content = player.getContent();
        if (content.isPresent()) {
            return Optional.of(content.get().get(String.valueOf(accountId)));
        }
        return Optional.empty();
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
