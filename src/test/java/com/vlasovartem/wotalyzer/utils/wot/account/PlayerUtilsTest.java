package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.utils.query.builder.AccountParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 24/12/2016.
 */
public class PlayerUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private PlayerUtils utils;

    @Test
    public void getPlayerTest() {
        long accountId = 231588;
        String uri = buildUri(AccountParamBuilder.newBuilder().withAccountId(accountId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/account/player.json"));
        Optional<Player> player = utils.getPlayer(accountId);
        Assert.assertTrue(player.isPresent());
        Assert.assertEquals(9840, player.get().getGlobalRating());
    }

}
