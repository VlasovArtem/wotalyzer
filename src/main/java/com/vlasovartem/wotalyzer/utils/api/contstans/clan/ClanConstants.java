package com.vlasovartem.wotalyzer.utils.api.contstans.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 25/12/2016.
 */
public class ClanConstants extends BasicAPIConstants {

    private static ClanConstants constants;

    public static ClanConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanConstants();
        }
        return constants;
    }

    private ClanConstants() {
        super("https://api.worldoftanks.ru/wgn/clans/info");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, ACCESS_TOKEN_PARAM, EXTRA_PARAM, GAME_PARAM));
        addRequiredParams(Collections.singletonList(CLAN_ID_PARAM));
    }

}
