package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehiclesConstants extends VehicleBasicConstants {
    //MainUtils URL for API that return list of available vehicles
    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/vehicles/";
    //Nation of the returned list of vehicles
    String NATION_PARAM = "nation";
    //Tier of the vehicles
    String TIER_PARAM = "tier";
    String TYPE_PARAM = "type";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(VehicleBasicConstants.BASIC_API_CONSTANTS, NATION_PARAM, TIER_PARAM, TYPE_PARAM);
}
