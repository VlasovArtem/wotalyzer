package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.SeasonRatingNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonRatingNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.VEHICLE_LEVEL_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonRatingNeighborUtils extends MainUtils<SeasonRatingNeighbor> {

    public SeasonRatingNeighborUtils() {
        super(SeasonRatingNeighbor.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonRatingNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonRatingNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonRatingNeighborConstants.REQUIRED_PARAMS;
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
                    case LIMIT_PARAM:
                        queryParams.replace(LIMIT_PARAM, MainValidator.validateLimit((Integer) entrySet.getValue(), 1, 99, 10));
                        break;
                }
            }
        }
        return true;
    }
}
