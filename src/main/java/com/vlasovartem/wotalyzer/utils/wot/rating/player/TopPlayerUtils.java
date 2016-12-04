package com.vlasovartem.wotalyzer.utils.wot.rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RankField;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.TopPlayer;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.TopPlayerConstants;
import com.vlasovartem.wotalyzer.utils.wot.rating.RatingUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimitWithMax;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateBattleType;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateDate;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TopPlayerUtils extends RatingUtils<TopPlayer> {

    public List<TopPlayer> getTopPlayers(@NotNull RankField field, @NotNull RatingType type) {
        return getTopPlayers(field, type, null);
    }

    public List<TopPlayer> getTopPlayers(@NotNull RankField field, @NotNull RatingType ratingType, BattleType battleType) {
        return getApiResponseList(newBuilder()
                .withRankField(field)
                .withType(ratingType)
                .withBattleType(battleType)
                .build())
                .getContent()
                .orElse(Collections.emptyList());
    }

    @Override
    protected Class<TopPlayer> getType() {
        return TopPlayer.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return TopPlayerConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TopPlayerConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TopPlayerConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateBattleType(), validateDate(), validateLimitWithMax(1000, 10));
    }

}
