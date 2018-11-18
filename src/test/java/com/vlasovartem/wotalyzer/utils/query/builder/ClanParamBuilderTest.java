package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ClanRankField;
import org.junit.Test;

import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 11/12/2016.
 */
public class ClanParamBuilderTest {

    @Test
    public void withClanIdTest() {
        int clanId = 999;
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withClanId(clanId).build();
        assertEquals(clanId, queryParams.get(CLAN_ID_PARAM));
    }

    @Test
    public void withFrontIdTest() {
        String frontId = "test_front_id";
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withFrontId(frontId).build();
        assertEquals(frontId, queryParams.get(FRONT_ID_PARAM));
    }

    @Test
    public void withSeasonIdTest() {
        String seasonId = "test_season_id";
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withSeasonId(seasonId).build();
        assertEquals(seasonId, queryParams.get(SEASON_ID_PARAM));
    }

    @Test
    public void withVehicleLevelTest() {
        int vehicleLevel = 10;
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withVehicleLevel(vehicleLevel).build();
        assertEquals(vehicleLevel, queryParams.get(VEHICLE_LEVEL_PARAM));
    }

    @Test
    public void withEvventIdTest() {
        String eventId = "test_event_id";
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withEventId(eventId).build();
        assertEquals(eventId, queryParams.get(EVENT_ID_PARAM));
    }

    @Test
    public void withRankFieldTest() {
        Map<String, Object> queryParams = ClanParamBuilder.newBuilder().withRankField(ClanRankField.BATTLES_COUNT_AVG).build();
        assertEquals(ClanRankField.BATTLES_COUNT_AVG.getValue(), queryParams.get(RANK_FIELD_PARAM));
    }

}
