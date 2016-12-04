package com.vlasovartem.wotalyzer.utils.wot.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanRatingConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingUtils extends MainUtils<ClanRating> {

    public Optional<ClanRating> getClanRating(@NotNull int clanId) {
        return convertMapToObject(getApiResponseMap(newBuilder().withClanId(clanId).build()));
    }

    @Override
    protected Class<ClanRating> getType() {
        return ClanRating.class;
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
