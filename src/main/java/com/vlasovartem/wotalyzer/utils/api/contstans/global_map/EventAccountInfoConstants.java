package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountInfoConstants extends BasicAPIConstants {

    private static EventAccountInfoConstants constants;

    public static EventAccountInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventAccountInfoConstants();
        }
        return constants;
    }

    private EventAccountInfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventaccountinfo");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM));
        addRequiredParams(Arrays.asList(ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM));
    }

}
