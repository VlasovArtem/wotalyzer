package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class VehicleProfileUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private VehicleProfileUtils utils;

    @Test
    public void getVehicleProfileTest() {
        long tankId = 14881;
        String uri = buildUri(VehicleParamBuilder.newBuilder().withTankId(tankId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle-profile.json"));
        Optional<VehicleProfile> vehicleProfile = utils.getVehicleProfile(tankId);
        Assert.assertTrue(vehicleProfile.isPresent());
        Assert.assertEquals(vehicleProfile.get().getId(), tankId);
    }
}
