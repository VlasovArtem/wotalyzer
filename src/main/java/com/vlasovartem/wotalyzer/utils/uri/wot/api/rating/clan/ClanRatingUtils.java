package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanRatingConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingUtils extends MainUtils<ClanRating> {

    public ClanRatingUtils() {
        super(ClanRating.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanRatingConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanRatingConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanRatingConstants.REQUIRED_PARAMS;
    }
}
