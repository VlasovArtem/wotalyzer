package com.vlasovartem.wotalyzer.utils.wot.player_rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanRating;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan.ClanRatingConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingUtils extends MainUtils<ClanRating> {

    public Optional<ClanRating> getClanRating(@NotNull int clanId) {
        return convertMapToObject(getApiResponseMap(ClanParamBuilder.newBuilder().withClanId(clanId).build()));
    }

    @Override
    protected Class<ClanRating> getType() {
        return ClanRating.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanRatingConstants.getInstance();
    }

}
