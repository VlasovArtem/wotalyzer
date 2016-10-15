package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.AccountRating;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.AccountRatingConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class AccountRatingUtils extends RatingUtils<AccountRating> {

    private static final Logger LOGGER = LogManager.getLogger(AccountRatingUtils.class);

    public AccountRatingUtils() {
        super(AccountRating.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(RatingValidator.validateBattleType(), RatingValidator.validateDate());
    }


}
