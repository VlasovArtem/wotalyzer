package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleConfiguration;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder.newBuilder;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class VehicleConfigurationUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private VehicleConfigurationUtils utils;

    @Test
    public void getVehicleConfigurationTest() {
        long tankId = 14881;
        String uri = buildUri(newBuilder().withTankId(tankId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle-configuration.json"));
        Optional<VehicleConfiguration> vehicleConfiguration = utils.getVehicleConfiguration(tankId);
        assertTrue(vehicleConfiguration.isPresent());
        assertTrue(vehicleConfiguration.get().isDefault());
    }
}
