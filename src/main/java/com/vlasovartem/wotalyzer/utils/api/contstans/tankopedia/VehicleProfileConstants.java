package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleProfileConstants extends VehicleBasicConstants {
    //Basic API URL
    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/vehicleprofile/";
    String ENGINE_ID_PARAM = "engine_id";
    String GUN_ID_PARAM = "gun_id";
    String SUSPENSION_ID_PARAM = "suspension_id";
    String TURRET_ID_PARAM = "turret_id";
    String RADIO_ID_PARAM = "radio_id";
    String PROFILE_ID_PARAM = "profile_id";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(VehicleBasicConstants.BASIC_API_CONSTANTS, ENGINE_ID_PARAM, GUN_ID_PARAM, SUSPENSION_ID_PARAM, TURRET_ID_PARAM, RADIO_ID_PARAM, PROFILE_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, TANK_ID_PARAM);
}
