package com.vlasovartem.wotalyzer.utils.wot.rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.RankField;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.RatingType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.Neighbor;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.NeighborConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.rating.RatingUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.RatingParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateBattleType;
import static com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator.validateDate;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class NeighborUtils extends RatingUtils<Neighbor> {

    public List<Neighbor> getNeighbors(@NotNull long accountId, @NotNull RankField rankField, @NotNull RatingType ratingType) {
        APIResponse<List<Neighbor>> apiResponseList = getApiResponseList(newBuilder()
                .withType(ratingType)
                .withRankField(rankField)
                .withAccountId(accountId)
                .build());
        return apiResponseList.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<Neighbor> getType() {
        return Neighbor.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return NeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return NeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return NeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateBattleType(), validateDate(), MainValidator.validateLimit(0, 50, 5));
    }

}
