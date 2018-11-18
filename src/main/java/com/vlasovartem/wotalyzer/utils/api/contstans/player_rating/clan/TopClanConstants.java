package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class TopClanConstants extends BasicAPIConstants {

    private static TopClanConstants constants;

    public static TopClanConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new TopClanConstants();
        }
        return constants;
    }

    private TopClanConstants() {
        super("https://api.worldoftanks.ru/wot/clanratings/top");
        addBasicApiConstants(Arrays.asList(RANK_FIELD_PARAM, DATE_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Collections.singletonList(RANK_FIELD_PARAM));
    }

}
