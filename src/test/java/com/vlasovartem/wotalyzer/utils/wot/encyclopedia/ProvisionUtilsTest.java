package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Provision;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ProvisionType;
import com.vlasovartem.wotalyzer.utils.query.builder.EncyclopediaParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class ProvisionUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private ProvisionUtils utils;

    @Test
    public void getProvisionsTest() {
        String uri = buildUri(Collections.emptyMap(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/provision/provision.json"));
        List<Provision> provisions = utils.getProvisions();
        Assert.assertFalse(provisions.isEmpty());
    }

    @Test
    public void getProvisionsByIdTest() {
        long provisionId = 4859;
        String uri = buildUri(EncyclopediaParamBuilder.newBuilder().withProvisionId(provisionId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/provision/provision-by-id.json"));
        Optional<Provision> provision = utils.getProvision(provisionId);
        Assert.assertTrue(provision.isPresent());
        Assert.assertEquals(provision.get().getId(), provisionId);
    }

    @Test
    public void getProvisionsByTypeTest() {
        String uri = buildUri(EncyclopediaParamBuilder.newBuilder().withProvisionType(ProvisionType.EQUIPMENT).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/provision/provision-by-type.json"));
        List<Provision> provision = utils.getProvision(ProvisionType.EQUIPMENT);
        Assert.assertFalse(provision.isEmpty());
    }
}
