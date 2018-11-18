package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicle;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.VehicleType;
import com.vlasovartem.wotalyzer.utils.wot.BasicWotTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder.newBuilder;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by artemvlasov on 27/12/2016.
 */
public class VehicleUtilsTest extends BasicWotTest {

    @InjectMocks
    @Autowired
    private VehicleUtils utils;

    @Test
    public void getVehicleProfileTest() {
        long tankId = 10785;
        String uri = buildUri(newBuilder().withTankId(tankId).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle.json"));
        Optional<Vehicle> vehicle = utils.getVehicle(tankId);
        assertTrue(vehicle.isPresent());
        assertEquals(vehicle.get().getId(), tankId);
    }

    @Test
    public void getVehicleProfileByTanksIdTest() {
        List<Long> tankIds = Arrays.asList(14881L, 6145L);
        String uri = buildUri(newBuilder().withTankIds(tankIds).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle-tank-ids.json"));
        List<Vehicle> vehicles = utils.getVehicles(tankIds);
        assertFalse(vehicles.isEmpty());
        assertTrue(vehicles.stream().allMatch(vehicle -> tankIds.contains(vehicle.getId())));
    }

    @Test
    public void getVehicleProfileByTanksIdAndFieldsTest() throws Exception {
        List<Long> tankIds = Arrays.asList(14881L, 6145L);
        List<String> fields = Arrays.asList("is_premium", "tank_id");
        String uri = buildUri(newBuilder().withTankIds(tankIds).withFields(fields).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle-tank-ids-fields.json"));
        List<Vehicle> vehicles = utils.getVehicles(tankIds, fields);
        assertFalse(vehicles.isEmpty());
        assertTrue(vehicles.stream().allMatch(vehicle -> tankIds.contains(vehicle.getId())));
        assertTrue(vehicles.stream().noneMatch(Vehicle::isPremium));
    }

    @Test
    public void getVehiclesByTypeTest() {
        String uri = buildUri(newBuilder().withVehicleType(VehicleType.HEAVY_TANK).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle-type.json"));
        List<Vehicle> vehicles = utils.getVehicles(VehicleType.HEAVY_TANK);
        assertFalse(vehicles.isEmpty());
        assertTrue(vehicles.stream().allMatch(vehicle -> VehicleType.HEAVY_TANK.equals(vehicle.getType())));
    }

    @Test
    public void getVehiclesByNationTest() {
        String uri = buildUri(newBuilder().withNation(Nation.FRANCE).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle-nation.json"));
        List<Vehicle> vehicles = utils.getVehicles(Nation.FRANCE);
        assertFalse(vehicles.isEmpty());
        assertTrue(vehicles.stream().allMatch(vehicle -> Nation.FRANCE.equals(vehicle.getNation())));
    }

    @Test
    public void getVehiclesByTierTest() {
        String uri = buildUri(newBuilder().withTier(10).build(), utils.getAPIConstants());
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(getResponseEntity("wot-api-response-example/encyclopedia/vehicle/vehicle-tier.json"));
        List<Vehicle> vehicles = utils.getVehicles(10);
        assertFalse(vehicles.isEmpty());
        assertTrue(vehicles.stream().allMatch(vehicle -> vehicle.getTier() == 10));
    }
}
