package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRatingDate;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanRatingDateConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingDateUtils extends MainUtils<ClanRatingDate> {

    public ClanRatingDateUtils() {
        super(ClanRatingDate.class);
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
}
