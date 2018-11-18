package com.vlasovartem.wotalyzer.utils.wot.player_rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.player.RatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.RatingDateConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

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
        return convertMapToObject(getApiResponseMap(RatingParamBuilder.newBuilder()
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
    protected BasicAPIConstants getAPIConstants() {
        return RatingDateConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(RatingValidator.validateBattleType());
    }
}
