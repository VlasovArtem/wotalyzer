package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.RatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.RatingDateConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class RatingDateUtils extends MainUtils<RatingDate> {

    public RatingDateUtils() {
        super(RatingDate.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return RatingDateConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return RatingDateConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return RatingDateConstants.REQUIRED_PARAMS;
    }
}
