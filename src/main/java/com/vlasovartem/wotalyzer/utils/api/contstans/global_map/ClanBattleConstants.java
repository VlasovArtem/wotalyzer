package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanBattleConstants extends BasicAPIConstants {

    private static ClanBattleConstants constants;

    public static ClanBattleConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanBattleConstants();
        }
        return constants;
    }

    private ClanBattleConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/clanbattles");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Collections.singletonList(CLAN_ID_PARAM));
    }

}
