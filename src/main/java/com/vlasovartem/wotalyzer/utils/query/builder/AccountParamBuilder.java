package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 22/11/2016.
 */
public class AccountParamBuilder extends QueryParamBuilder {

    public static AccountParamBuilder newBuilder() {
        if (Objects.isNull(builder)) {
            builder = new AccountParamBuilder();
        }
        return (AccountParamBuilder) builder;
    }

    private AccountParamBuilder() {
        super();
    }

    public AccountParamBuilder withBattleType(String value) {
        return (AccountParamBuilder) customParam(WOTAPIConstants.BATTLE_TYPE_PARAM, value);
    }

}
