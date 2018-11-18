package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TopPlayerConstants extends BasicAPIConstants {

    private static TopPlayerConstants constants;

    public static TopPlayerConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new TopPlayerConstants();
        }
        return constants;
    }

    private TopPlayerConstants() {
        super("https://api.worldoftanks.ru/wot/ratings/top");
        addBasicApiConstants(Arrays.asList(RANK_FIELD_PARAM, TYPE_PARAM, BATTLE_TYPE_PARAM, DATE_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Arrays.asList(RANK_FIELD_PARAM, TYPE_PARAM));
    }

}
