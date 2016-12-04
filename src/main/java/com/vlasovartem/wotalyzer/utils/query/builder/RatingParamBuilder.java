package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.RankField;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class RatingParamBuilder extends QueryParamBuilder {

    public static RatingParamBuilder newBuilder() {
        if (Objects.isNull(builder)) {
            builder = new RatingParamBuilder();
        }
        return (RatingParamBuilder) builder;
    }

    private RatingParamBuilder() {
        super();
    }

    public RatingParamBuilder withType(RatingType type) {
        return (RatingParamBuilder) customParam(WOTAPIConstants.TYPE_PARAM, type.getValue());
    }

    public RatingParamBuilder withRankField(RankField field) {
        return (RatingParamBuilder) customParam(WOTAPIConstants.RANK_FIELD_PARAM, field.getValue());
    }

}
