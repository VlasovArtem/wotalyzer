package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Module;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ModuleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.utils.query.builder.EncyclopediaParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 26/12/2016.
 */
public class ModuleUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private ModuleUtils utils;

    @Test
    public void getModuleTest() {
        String uri = buildUri(EncyclopediaParamBuilder.newBuilder().withNation(Nation.USA).withModuleType(ModuleType.GUN).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/module.json"));
        List<Module> module = utils.getModule(Nation.USA, ModuleType.GUN);
        Assert.assertFalse(module.isEmpty());
    }

}
