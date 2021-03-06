package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.PersonalReserve;
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
public class PersonalReserveUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private PersonalReserveUtils utils;

    @Test
    public void getPersonalReservesTest() throws Exception {
        String uri = buildUri(Collections.emptyMap(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/personal-reserve.json"));
        List<PersonalReserve> personalReserves = utils.getPersonalReserves();
        Assert.assertFalse(personalReserves.isEmpty());
    }
}
