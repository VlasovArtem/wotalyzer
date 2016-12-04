package com.vlasovartem.wotalyzer.utils.wot.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanRatingDateConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingDateUtils extends MainUtils<ClanRatingDate> {

    public List<ClanRatingDate> getClanRatingDates() {
        return convertMapToList(getApiResponseMap(""));
    }

    @Override
    protected Class<ClanRatingDate> getType() {
        return ClanRatingDate.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanRatingDateConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanRatingDateConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanRatingDateConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimitWithMax(365, 7));
    }

}
