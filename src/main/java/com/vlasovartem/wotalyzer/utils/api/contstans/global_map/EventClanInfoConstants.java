package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventClanInfoConstants extends BasicAPIConstants {

    private static EventClanInfoConstants constants;

    public static EventClanInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventClanInfoConstants();
        }
        return constants;
    }

    private EventClanInfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventclaninfo");
        List<String> params = Arrays.asList(CLAN_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM);
        addBasicApiConstants(params);
        addRequiredParams(params);
    }

}
