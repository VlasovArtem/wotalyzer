package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonRatingConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateVehicleLevelParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonRatingUtils extends MainUtils<SeasonRating> {

    public SeasonRatingUtils() {
        super(SeasonRating.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonRatingConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonRatingConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonRatingConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePageNoParameter(), validateLimit(1, 100, 10), validateVehicleLevelParameter());
    }
}
