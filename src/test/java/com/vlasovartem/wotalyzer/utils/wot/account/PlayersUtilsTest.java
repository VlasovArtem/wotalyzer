package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import com.vlasovartem.wotalyzer.utils.api.contstans.enums.NameTypeParameter;
import com.vlasovartem.wotalyzer.utils.query.builder.AccountParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 24/12/2016.
 */
public class PlayersUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private PlayersUtils utils;

    @Test
    public void findPlayersByNameTest() {
        String name = "Martens";
        String uri = buildUri(AccountParamBuilder.newBuilder().withName(name).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/account/players.json"));
        List<Players> playersByName = utils.findPlayersByName(name);
        assertThat(playersByName, hasSize(1));
        assertEquals(name, playersByName.get(0).getNickname());
    }

    @Test
    public void findPlayersByName2ArgsTest() {
        String name = "Martens";
        String uri = buildUri(AccountParamBuilder.newBuilder().withName(name).withType(NameTypeParameter.EXACT).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/account/players.json"));
        List<Players> playersByName = utils.findPlayersByName(name, NameTypeParameter.EXACT);
        assertThat(playersByName, hasSize(1));
        assertEquals(name, playersByName.get(0).getNickname());
    }

    @Test(expected = WotAPIValidationException.class)
    public void findPlayersByNameWithEmptyNameTest() {
        String name = "";
        String uri = buildUri(AccountParamBuilder.newBuilder().withName(name).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/error/account/errorEmptySearchField.json"));
        utils.findPlayersByName(name);
    }

    @Test(expected = WotAPIValidationException.class)
    public void findPlayersByName2ArgsIncorrectNameTest() {
        String name = "t";
        String uri = buildUri(AccountParamBuilder.newBuilder().withName(name).withType(NameTypeParameter.EXACT).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/error/account/errorIncorrectSearchLength.json"));
        utils.findPlayersByName(name, NameTypeParameter.START_WITH);
    }
}
