package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public interface VehiclesConstants extends VehicleBasicConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/vehicles/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(VehicleBasicConstants.BASIC_API_CONSTANTS, NATION_PARAM, TIER_PARAM, TYPE_PARAM);

}
