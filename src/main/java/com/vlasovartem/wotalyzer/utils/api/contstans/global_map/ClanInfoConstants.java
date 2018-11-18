package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCESS_TOKEN_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.CLAN_ID_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanInfoConstants extends BasicAPIConstants {

    private static ClanInfoConstants constants;

    public static ClanInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanInfoConstants();
        }
        return constants;
    }

    private ClanInfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/claninfo");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, ACCESS_TOKEN_PARAM));
        addRequiredParams(Collections.singletonList(CLAN_ID_PARAM));
    }

}
