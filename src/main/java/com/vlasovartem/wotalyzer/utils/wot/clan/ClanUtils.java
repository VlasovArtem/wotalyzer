package com.vlasovartem.wotalyzer.utils.wot.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.clan.Clan;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.clan.ClanConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by artemvlasov on 25/12/2016.
 */
@Component
public class ClanUtils extends MainUtils<Clan> {

    public Optional<Clan> getClan(int clanId) {
        return APIResponseUtils.convertMapToObject(getApiResponseMap(ClanParamBuilder.newBuilder().withClanId(clanId).build()));
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanConstants.getInstance();
    }

    @Override
    protected Class<Clan> getType() {
        return Clan.class;
    }
}
