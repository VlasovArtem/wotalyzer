package com.vlasovartem.wotalyzer.utils;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by artemvlasov on 02/11/2016.
 */
public class QueryParamBuilder {

    private Map<String, Object> params;

    public static QueryParamBuilder newBuilder() {
        return new QueryParamBuilder();
    }

    private QueryParamBuilder() {
        params = new HashMap<>();
    }

    public QueryParamBuilder customParam(String name, Object value) {
        if (Objects.nonNull(name) && Objects.nonNull(value))
            params.put(name, value);
        return this;
    }

    public QueryParamBuilder withAccountId(long accountId) {
        return customParam(WOTAPIConstants.ACCOUNT_ID_PARAM, accountId);
    }

    public QueryParamBuilder withBattleType(String value) {
        return customParam(WOTAPIConstants.BATTLE_TYPE_PARAM, value);
    }

    public QueryParamBuilder withDate(LocalDateTime date) {
        return customParam(WOTAPIConstants.DATE_PARAM, Objects.nonNull(date) ? date.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null);
    }

    public QueryParamBuilder withFields(List<String> value) {
        return customParam(WOTAPIConstants.FIELDS_PARAM, value);
    }

    public Map<String, Object> build() {
        return params;
    }
}
