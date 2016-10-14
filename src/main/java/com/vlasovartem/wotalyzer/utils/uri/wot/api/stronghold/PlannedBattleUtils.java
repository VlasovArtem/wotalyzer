package com.vlasovartem.wotalyzer.utils.uri.wot.api.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.PlannedBattle;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.PlannedBattleConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlannedBattleUtils extends MainUtils<PlannedBattle> {

    public PlannedBattleUtils() {
        super(PlannedBattle.class);
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
