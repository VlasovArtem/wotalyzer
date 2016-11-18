package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonClanInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonClanInfoUtils extends MainUtils<SeasonClanInfo> {

    @Override
    protected Class getType() {
        return SeasonClanInfo.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonClanInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonClanInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonClanInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(GlobalMapValidator.validateVehicleLevelParameter());
    }
}
