package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerAchievement;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIException;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamExtBuilder.newBuilder;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 17/10/2016.
 */
public class PlayerAchievementsUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private PlayerAchievementUtils utils;

    @Test
    public void getPlayerAchievements() {
        long accountId = 231588;
        String uri = buildUri(newBuilder().withAccountId(accountId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/account/playerAchievement.json"));
        Optional<PlayerAchievement> playerAchievements = utils.getPlayerAchievements(accountId);
        PlayerAchievement playerAchievement = playerAchievements.orElse(null);
        assertNotNull(playerAchievement);
    }



    @Test(expected = WotAPIException.class)
    public void getPlayerAchievementsInvalidFieldTest() {
        long accountId = 231588;
        String uri = buildUri(newBuilder().withAccountId(accountId).withFields(Collections.singletonList("test")).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/error/errorInvalidField.json"));
        Optional<PlayerAchievement> playerAchievements = utils.getPlayerAchievements(accountId);
    }

}
