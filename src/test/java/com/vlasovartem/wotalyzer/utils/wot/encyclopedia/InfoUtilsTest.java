package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Info;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class InfoUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private InfoUtils utils;

    @Test
    public void getInfoTest() {
        String uri = buildUri(Collections.emptyMap(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/tankopedia-info.json"));
        Optional<Info> info = utils.getInfo();
        Assert.assertTrue(info.isPresent());
        assertEquals("9.16", info.get().getGameVersion());
    }


}
