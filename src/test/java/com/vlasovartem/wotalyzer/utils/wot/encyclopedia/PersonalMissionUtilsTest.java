package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.PersonalMission;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class PersonalMissionUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private PersonalMissionUtils utils;

    @Test
    public void getPersonalMissionsTest() {
        String uri = buildUri(Collections.emptyMap(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/personal-mission.json"));
        List<PersonalMission> personalMissions = utils.getPersonalMissions();
        Assert.assertFalse(personalMissions.isEmpty());
    }


}
