package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventClanRatingNeighborConstants extends BasicAPIConstants {

    private static EventClanRatingNeighborConstants constants;

    public static EventClanRatingNeighborConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventClanRatingNeighborConstants();
        }
        return constants;
    }

    private EventClanRatingNeighborConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventratingneighbors");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM, LIMIT_PARAM));
        addRequiredParams(Arrays.asList(CLAN_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM));
    }

}
