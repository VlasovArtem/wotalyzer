package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.CLAN_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.DATE_PARAM;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanRatingConstants extends BasicAPIConstants {

    private static ClanRatingConstants constants;

    public static ClanRatingConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanRatingConstants();
        }
        return constants;
    }

    private ClanRatingConstants() {
        super("https://api.worldoftanks.ru/wot/clanratings/clans");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, DATE_PARAM));
        addRequiredParams(Collections.singletonList(CLAN_ID_PARAM));
    }

}
