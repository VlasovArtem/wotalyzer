package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayerVehicleConstants extends PlayerBasicConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/tanks/";
    String TANK_ID_PARAM = "tank_id";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(PlayerBasicConstants.BASIC_API_CONSTANTS, TANK_ID_PARAM);

}
