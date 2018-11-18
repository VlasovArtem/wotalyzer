package com.vlasovartem.wotalyzer.utils.wot.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.clan.Clan;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 25/12/2016.
 */
public class ClanUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private ClanUtils utils;

    @Test
    public void getClanTest() {
        int clanId = 223790;
        String uri = buildUri(ClanParamBuilder.newBuilder().withClanId(clanId).customParam(WOTAPIConstants.GAME_PARAM, "wot").build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/clan/clan.json"));
        Optional<Clan> clan = utils.getClan(clanId);
        assertTrue(clan.isPresent());
        assertEquals("KOPM2 - построй свой Укреп", clan.get());
    }
}
