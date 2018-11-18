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
public class ClanProvinceConstants extends BasicAPIConstants {

    private static ClanProvinceConstants constants;

    public static ClanProvinceConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanProvinceConstants();
        }
        return constants;
    }

    private ClanProvinceConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/clanprovinces");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, ACCESS_TOKEN_PARAM));
        addRequiredParams(Collections.singletonList(CLAN_ID_PARAM));
    }

}
