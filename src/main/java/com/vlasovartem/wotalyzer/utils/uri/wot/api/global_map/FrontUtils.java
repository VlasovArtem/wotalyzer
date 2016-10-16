package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Front;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.FrontConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class FrontUtils extends MainUtils<Front> {

    public FrontUtils() {
        super(Front.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return FrontConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return FrontConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return FrontConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(MainValidator.validatePageNoParameter(), MainValidator.validateLimit(0, 100, 100));
    }
}
