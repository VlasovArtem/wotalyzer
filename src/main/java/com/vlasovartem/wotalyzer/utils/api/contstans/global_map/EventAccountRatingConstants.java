package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class EventAccountRatingConstants extends BasicAPIConstants {

    private static EventAccountRatingConstants constants;

    public static EventAccountRatingConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventAccountRatingConstants();
        }
        return constants;
    }

    private EventAccountRatingConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventaccountratings");
        addBasicApiConstants(Arrays.asList(EVENT_ID_PARAM, FRONT_ID_PARAM, IN_RATING_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Arrays.asList(EVENT_ID_PARAM, FRONT_ID_PARAM));
    }

}
