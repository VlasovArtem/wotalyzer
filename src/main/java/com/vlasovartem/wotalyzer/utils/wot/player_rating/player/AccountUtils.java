package com.vlasovartem.wotalyzer.utils.wot.player_rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.player.Account;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.AccountConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import com.vlasovartem.wotalyzer.utils.wot.player_rating.RatingUtils;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 11/10/2016.
 */
@Component
public class AccountUtils extends RatingUtils<Account> {

    private static Map<String, String> defaultValueMap;

    public Optional<Account> getAccount(@NotNull long accountId, @NotNull RatingType ratingType) {
        return getAccount(accountId, ratingType, null);
    }

    public Optional<Account> getAccount(@NotNull long accountId, @NotNull RatingType ratingType, BattleType battleType) {
        return convertMapToObject(getApiResponseMap(RatingParamBuilder.newBuilder()
                .withType(ratingType)
                .withBattleType(battleType)
                .withAccountId(accountId)
                .build()));
    }

    @Override
    protected Class<Account> getType() {
        return Account.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return AccountConstants.getInstance();
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
