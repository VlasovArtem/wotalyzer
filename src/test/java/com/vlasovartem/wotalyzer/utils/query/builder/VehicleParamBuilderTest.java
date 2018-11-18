package com.vlasovartem.wotalyzer.utils.query.builder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder.newBuilder;
import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class VehicleParamBuilderTest {

    @Test
    public void withTankIdTest() {
        long tankId = 999;
        Map<String, Object> queryParams = newBuilder().withTankId(tankId).build();
        assertEquals(tankId, queryParams.get(TANK_ID_PARAM));
    }

    @Test
    public void withTankIdsTest() {
        List<Long> tankIds = Arrays.asList(999L, 1000L, 1001L);
        Map<String, Object> queryParams = newBuilder().withTankIds(tankIds).build();
        assertEquals(
                tankIds
                        .stream()
                        .map(String::valueOf).collect(Collectors.joining(",")),
                queryParams.get(TANK_ID_PARAM));
    }
}
