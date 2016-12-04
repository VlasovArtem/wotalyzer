package com.vlasovartem.wotalyzer.utils.wot.rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.RatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.RatingDateConstants;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class RatingDateUtils extends MainUtils<RatingDate> {

    public Optional<RatingDate> getRatingDate(RatingType type) {
        return getRatingDate(type, null, null);
    }

    public Optional<RatingDate> getRatingDate(RatingType type, Long accountId) {
        return getRatingDate(type, null, accountId);
    }

    public Optional<RatingDate> getRatingDate(RatingType ratingType, BattleType battleType) {
        return getRatingDate(ratingType, battleType, null);
    }

    public Optional<RatingDate> getRatingDate(@NotNull RatingType ratingType, BattleType battleType, Long accountId) {
        return convertMapToObject(getApiResponseMap(newBuilder()
                .withType(ratingType)
                .withBattleType(battleType)
                .withAccountId(accountId)
                .build()));
    }


    @Override
    protected Class<RatingDate> getType() {
        return RatingDate.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return RatingDateConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RatingDateConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RatingDateConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(RatingValidator.validateBattleType());
    }
}
