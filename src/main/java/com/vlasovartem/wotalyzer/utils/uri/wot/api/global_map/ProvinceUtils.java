package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Province;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ProvinceConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ProvinceUtils extends MainUtils<Province> {

    public ProvinceUtils() {
        super(Province.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ProvinceConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ProvinceConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ProvinceConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validatePrimeHourParameter(), validatePageNoParameter(), validateOrderByParameter(), validateLimit(0, 100, 100), validateLandingTypeParameter());
    }
}
