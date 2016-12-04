package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 02/11/2016.
 */
public class QueryParamBuilder {

    private Map<String, Object> params;
    protected static QueryParamBuilder builder;

    public static QueryParamBuilder newBuilder() {
        if (Objects.isNull(builder)) {
            builder = new QueryParamBuilder();
        }
        return builder;
    }

    QueryParamBuilder() {
        params = new HashMap<>();
    }

    public QueryParamBuilder customParam(String name, Object value) {
        if (Objects.nonNull(name) && Objects.nonNull(value))
            params.put(name, value);
        return this;
    }

    public QueryParamBuilder withDate(LocalDateTime date) {
        return customParam(WOTAPIConstants.DATE_PARAM, Objects.nonNull(date) ? date.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : null);
    }

    public QueryParamBuilder withFields(List<String> values) {
        if (Objects.nonNull(values) && !values.isEmpty())
            return customParam(WOTAPIConstants.FIELDS_PARAM, values.stream().collect(Collectors.joining(",")));
        return this;
    }

    public QueryParamBuilder withAccountId(Long accountId) {
        return customParam(WOTAPIConstants.ACCOUNT_ID_PARAM, accountId);
    }

    public QueryParamBuilder withBattleType(BattleType battleType) {
        return customParam(WOTAPIConstants.BATTLE_TYPE_PARAM, battleType.getValue());
    }

    public Map<String, Object> build() {
        Map<String, Object> paramsClone = new HashMap<>(params);
        params.clear();
        return paramsClone
                .entrySet()
                .stream()
                .filter(data -> Objects.nonNull(data.getValue()) && (data.getValue() instanceof String && data.getValue().toString().isEmpty()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
