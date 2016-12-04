package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayersConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.enums.NameTypeParameter;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.account.AccountValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.SEARCH_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayersUtils extends MainUtils<Players> {

    private final static Logger LOGGER = LogManager.getLogger(PlayersUtils.class);

    public List<Players> findPlayesByName(String name) {
        APIResponse<List<Players>> apiResponse = getApiResponseList(newBuilder().customParam(SEARCH_PARAM, name).build());
        Optional<List<Players>> content = apiResponse.getContent();
        return content.isPresent() ? content.get() : Collections.emptyList();
    }

    public List<Players> findPlayersByName(String name, NameTypeParameter typeParameter) {
        APIResponse<List<Players>> apiResponseList = getApiResponseList(newBuilder().customParam(TYPE_PARAM, typeParameter.getValue()).customParam(SEARCH_PARAM, name).build());
        Optional<List<Players>> content = apiResponseList.getContent();
        if (content.isPresent()) {
            return content.get();
        }
        LOGGER.info("Players with name {} not found", name);
        return Collections.emptyList();
    }

    @Override
    protected Class<Players> getType() {
        return Players.class;
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
