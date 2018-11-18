package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class NeighborConstants extends BasicAPIConstants {

    private static NeighborConstants constants;

    public static NeighborConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new NeighborConstants();
        }
        return constants;
    }

    private NeighborConstants() {
        super("https://api.worldoftanks.ru/wot/ratings/neighbors");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, RANK_FIELD_PARAM, TYPE_PARAM, BATTLE_TYPE_PARAM, DATE_PARAM, LIMIT_PARAM));
        addRequiredParams(Arrays.asList(ACCOUNT_ID_PARAM, RANK_FIELD_PARAM, TYPE_PARAM));
    }

}
