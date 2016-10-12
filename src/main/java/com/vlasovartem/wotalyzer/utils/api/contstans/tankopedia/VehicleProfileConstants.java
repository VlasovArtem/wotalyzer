package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehicleProfileConstants extends VehicleBasicConstants {
    //Basic API URL
    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/vehicleprofile/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(VehicleBasicConstants.BASIC_API_CONSTANTS, ENGINE_ID_PARAM, GUN_ID_PARAM, SUSPENSION_ID_PARAM, TURRET_ID_PARAM, RADIO_ID_PARAM, PROFILE_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, TANK_ID_PARAM);
}
