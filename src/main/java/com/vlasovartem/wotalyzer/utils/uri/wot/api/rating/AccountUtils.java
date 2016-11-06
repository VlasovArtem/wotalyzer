package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.Account;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
@Component
public class AccountUtils extends RatingUtils<Account> {

    private static final Logger LOGGER = LogManager.getLogger(AccountUtils.class);
    private static Map<String, String> defaultValueMap;

    public AccountUtils() {
        super(Account.class);
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
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(RatingValidator.validateBattleType(), RatingValidator.validateDate(), RatingValidator.validateType());
    }

    @Override
    public Map<String, String> getDefaultValueMap() {
        if (Objects.isNull(defaultValueMap)) {
            defaultValueMap = new HashMap<>();
            defaultValueMap.put(WOTAPIConstants.BATTLE_TYPE_PARAM, "default");
        }
        return defaultValueMap;
    }
}
