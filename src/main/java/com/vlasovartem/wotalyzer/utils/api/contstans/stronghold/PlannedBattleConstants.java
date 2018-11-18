package com.vlasovartem.wotalyzer.utils.api.contstans.stronghold;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.CLAN_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlannedBattleConstants extends BasicAPIConstants {

    private static PlannedBattleConstants constants;

    public static PlannedBattleConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PlannedBattleConstants();
        }
        return constants;
    }

    private PlannedBattleConstants() {
        super("https://api.worldoftanks.ru/wot/stronghold/plannedbattles");
        List<String> params = Collections.singletonList(CLAN_ID_PARAM);
        addBasicApiConstants(params);
        addRequiredParams(params);
    }

}
