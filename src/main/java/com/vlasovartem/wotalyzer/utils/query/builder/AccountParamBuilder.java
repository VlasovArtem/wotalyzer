package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.enums.NameTypeParameter;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 22/11/2016.
 */
public class AccountParamBuilder extends QueryParamExtBuilder {

    public static AccountParamBuilder newBuilder() {
        return new AccountParamBuilder();
    }

    private AccountParamBuilder() {
        super();
    }

    public AccountParamBuilder withBattleType(String value) {
        return (AccountParamBuilder) customParam(BATTLE_TYPE_PARAM, value);
    }

    public AccountParamBuilder withName(String name) {
        return (AccountParamBuilder) customParam(SEARCH_PARAM, name);
    }

    public AccountParamBuilder withType(NameTypeParameter parameter) {
        return (AccountParamBuilder) customParam(TYPE_PARAM, parameter.getValue());
    }

}
