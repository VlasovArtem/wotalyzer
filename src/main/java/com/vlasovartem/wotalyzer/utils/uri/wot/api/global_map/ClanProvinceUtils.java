package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanProvince;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanProvinceConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanProvinceUtils extends MainUtils<ClanProvince> {

    public ClanProvinceUtils() {
        super(ClanProvince.class);
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateClanIDParameter());
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanProvinceConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanProvinceConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanProvinceConstants.REQUIRED_PARAMS;
    }
}
