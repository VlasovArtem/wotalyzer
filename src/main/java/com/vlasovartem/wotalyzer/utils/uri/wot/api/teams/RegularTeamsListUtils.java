package com.vlasovartem.wotalyzer.utils.uri.wot.api.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.RegularTeamsList;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.RegularTeamsListConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.rating.RatingValidator;
import com.vlasovartem.wotalyzer.utils.validators.teams.TeamsParametersValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ORDER_BY_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class RegularTeamsListUtils extends MainUtils<RegularTeamsList> {

    public RegularTeamsListUtils() {
        super(RegularTeamsList.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return RegularTeamsListConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RegularTeamsListConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RegularTeamsListConstants.REQUIRED_PARAMS;
    }

    @Override
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if (checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case LIMIT_PARAM:
                        int value = (int) entrySet.getValue();
                        queryParams.replace(LIMIT_PARAM, RatingValidator.validateLimit(value, 0, 100, 100));
                        break;
                    case ORDER_BY_PARAM:
                        return TeamsParametersValidator.validateOrderParameter((String) entrySet.getValue());
                }
            }
        }
        return true;
    }
}
