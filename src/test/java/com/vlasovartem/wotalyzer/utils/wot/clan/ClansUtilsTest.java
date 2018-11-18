package com.vlasovartem.wotalyzer.utils.wot.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.clan.Clan;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 25/12/2016.
 */
public class ClansUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private ClansUtils utils;

    @Test
    public void getClansTest() {
        String name = "KOPM2";
        String uri = buildUri(ClanParamBuilder.newBuilder().withName(name).customParam(WOTAPIConstants.GAME_PARAM, "wot").build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/clan/clans.json"));
        List<Clan> clans = utils.getClans(name);
        Assert.assertTrue(clans.size() > 0);
    }

    @Test(expected = WotAPIValidationException.class)
    public void getClansWithNameIncorrectLengthTest() {
        String name = "t";
        utils.getClans(name);
    }
}
