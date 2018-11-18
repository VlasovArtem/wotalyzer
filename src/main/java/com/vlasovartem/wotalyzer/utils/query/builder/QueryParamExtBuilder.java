package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

/**
 * Created by artemvlasov on 26/12/2016.
 */
public class QueryParamExtBuilder<T extends QueryParamBuilder> extends QueryParamBuilder {

    public static QueryParamExtBuilder newBuilder() {
        return new QueryParamExtBuilder();
    }

    QueryParamExtBuilder() {
        super();
    }

    @SuppressWarnings("unchecked")
    public T withAccountId(Long accountId) {
        return (T) customParam(WOTAPIConstants.ACCOUNT_ID_PARAM, accountId);
    }

}
