package com.vlasovartem.wotalyzer.utils.api.contstans.stronghold;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCESS_TOKEN_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.CLAN_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class ClanStrongholdConstants extends BasicAPIConstants {

    private static ClanStrongholdConstants constants;

    public static ClanStrongholdConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanStrongholdConstants();
        }
        return constants;
    }

    private ClanStrongholdConstants() {
        super("https://api.worldoftanks.ru/wot/stronghold/info");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, ACCESS_TOKEN_PARAM));
        addRequiredParams(Arrays.asList(CLAN_ID_PARAM));
    }

}
