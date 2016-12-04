package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.PlannedBattle;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.PlannedBattleConstants;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlannedBattleUtils extends MainUtils<PlannedBattle> {

    @Override
    protected Class getType() {
        return PlannedBattle.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return PlannedBattleConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlannedBattleConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlannedBattleConstants.REQUIRED_PARAMS;
    }
}
