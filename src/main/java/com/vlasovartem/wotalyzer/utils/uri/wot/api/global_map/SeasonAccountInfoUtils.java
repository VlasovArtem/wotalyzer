package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonAccountInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonAccountInfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.VEHICLE_LEVEL_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonAccountInfoUtils extends MainUtils<SeasonAccountInfo> {

    public SeasonAccountInfoUtils() {
        super(SeasonAccountInfo.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonAccountInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonAccountInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonAccountInfoConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case VEHICLE_LEVEL_PARAM:
                        boolean b = GlobalMapValidator.validateVehicleLevelParameter(entrySet.getValue());
                        if (!b)
                            return false;
                        break;
                }
            }
        }
        return true;
    }
}
