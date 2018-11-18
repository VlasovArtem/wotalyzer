package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.LIMIT_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingDateConstants extends BasicAPIConstants {

    private static ClanRatingDateConstants constants;

    public static ClanRatingDateConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanRatingDateConstants();
        }
        return constants;
    }

    private ClanRatingDateConstants() {
        super("https://api.worldoftanks.ru/wot/clanratings/dates");
        addBasicApiConstants(Collections.singletonList(LIMIT_PARAM));
    }

}
