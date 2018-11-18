package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountRatingNeighborConstants extends BasicAPIConstants {

    private static EventAccountRatingNeighborConstants constants;

    public static EventAccountRatingNeighborConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new EventAccountRatingNeighborConstants();
        }
        return constants;
    }

    private EventAccountRatingNeighborConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/eventaccountratingneighbors");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM, LIMIT_PARAM, NEIGHBOURS_COUNT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Arrays.asList(ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM));
    }

}
