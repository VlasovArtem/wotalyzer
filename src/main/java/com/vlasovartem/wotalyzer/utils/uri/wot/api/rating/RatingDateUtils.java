package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.RatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.RatingDateConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class RatingDateUtils extends MainUtils<RatingDate> {

    @Override
    protected Class getType() {
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
