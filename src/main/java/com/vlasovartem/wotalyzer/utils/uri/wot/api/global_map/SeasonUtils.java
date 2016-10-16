package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Season;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateStatusParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonUtils extends MainUtils<Season> {

    public SeasonUtils() {
        super(Season.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(1, 20, 5), validatePageNoParameter(), validateStatusParameter());
    }
}
