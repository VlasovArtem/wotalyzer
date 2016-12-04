package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 10/10/16.
 */
public interface VehicleConfigurationConstants extends VehicleBasicConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/vehicles/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, TANK_ID_PARAM, ORDER_BY_PARAM);

}
