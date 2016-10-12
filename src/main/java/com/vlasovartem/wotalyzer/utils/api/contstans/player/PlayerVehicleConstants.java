package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayerVehicleConstants extends PlayerBasicConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/tanks/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(PlayerBasicConstants.BASIC_API_CONSTANTS, TANK_ID_PARAM);

}
