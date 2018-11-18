package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.PlannedBattle;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.PlannedBattleConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlannedBattleUtils extends MainUtils<PlannedBattle> {

    @Override
    protected Class<PlannedBattle> getType() {
        return PlannedBattle.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return PlannedBattleConstants.getInstance();
    }

}
