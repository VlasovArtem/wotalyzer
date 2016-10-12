package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.Neighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.NeighborConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.rating.NeighborConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class NeighborUtils extends RatingUtils<Neighbor> {

    private static final Logger LOGGER = LogManager.getLogger(NeighborUtils.class);

    public NeighborUtils() {
        super(Neighbor.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return NeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return NeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return NeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case BATTLE_TYPE_PARAM:
                        queryParams.replace(BATTLE_TYPE_PARAM, validateBattleType(entrySet));
                        break;
                    case DATE_PARAM:
                        queryParams.replace(DATE_PARAM, validateDate(entrySet));
                        break;
                    case LIMIT_PARAM:
                        int limit = (int) entrySet.getValue();
                        if(limit < 0 || limit > 50) {
                            LOGGER.warn("Parameter {} has incorrect value {}, possible value should be from 0 to 50. Default value will be set: 5", LIMIT_PARAM, limit);
                            limit = 5;
                        }
                        queryParams.replace(LIMIT_PARAM, limit);
                        break;
                }
            }
        }
        return false;
    }

}
