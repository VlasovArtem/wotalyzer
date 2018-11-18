package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventClanRatingConstants extends BasicAPIConstants {

    private static EventClanRatingConstants constants;

    public static EventClanRatingConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventClanRatingConstants();
        }
        return constants;
    }

    private EventClanRatingConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventrating");
        addBasicApiConstants(Arrays.asList(EVENT_ID_PARAM, FRONT_ID_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Arrays.asList(EVENT_ID_PARAM, FRONT_ID_PARAM));
    }

}
