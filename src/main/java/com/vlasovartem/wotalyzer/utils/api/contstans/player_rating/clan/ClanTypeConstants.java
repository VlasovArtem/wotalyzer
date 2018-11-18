package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class ClanTypeConstants extends BasicAPIConstants {

    private static ClanTypeConstants constants;

    public static ClanTypeConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanTypeConstants();
        }
        return constants;
    }

    private ClanTypeConstants() {
        super("https://api.worldoftanks.ru/wot/clanratings/types");
    }

}
