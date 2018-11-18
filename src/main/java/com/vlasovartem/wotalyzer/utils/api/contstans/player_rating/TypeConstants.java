package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.BATTLE_TYPE_PARAM;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TypeConstants extends BasicAPIConstants {

    private static TypeConstants constants;

    public static TypeConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new TypeConstants();
        }
        return constants;
    }

    private TypeConstants() {
        super("https://api.worldoftanks.ru/wot/ratings/types");
        addBasicApiConstants(Collections.singletonList(BATTLE_TYPE_PARAM));
    }

}
