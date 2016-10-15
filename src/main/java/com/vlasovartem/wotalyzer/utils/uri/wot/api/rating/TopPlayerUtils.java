package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.TopPlayer;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.TopPlayerConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TopPlayerUtils extends RatingUtils<TopPlayer> {

    public TopPlayerUtils() {
        super(TopPlayer.class);
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
        return Arrays.asList(RatingValidator.validateBattleType(), RatingValidator.validateDate(), MainValidator.validateLimitWithMax(1000, 10));
    }

}
