package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class RatingDateConstants extends BasicAPIConstants {

    private static RatingDateConstants constants;

    public static RatingDateConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new RatingDateConstants();
        }
        return constants;
    }

    private RatingDateConstants() {
        super("https://api.worldoftanks.ru/wot/ratings/dates");
        addBasicApiConstants(Arrays.asList(TYPE_PARAM, ACCOUNT_ID_PARAM, BATTLE_TYPE_PARAM));
        addRequiredParams(Collections.singletonList(TYPE_PARAM));
    }

}
