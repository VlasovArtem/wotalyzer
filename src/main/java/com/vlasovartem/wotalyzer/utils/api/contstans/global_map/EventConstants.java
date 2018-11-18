package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventConstants extends BasicAPIConstants {

    private static EventConstants constants;

    public static EventConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventConstants();
        }
        return constants;
    }

    private EventConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/events");
        addBasicApiConstants(Arrays.asList(EVENT_ID_PARAM, LIMIT_PARAM, PAGE_NO_PARAM, STATUS_PARAM));
    }

}
