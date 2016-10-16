package com.vlasovartem.wotalyzer.utils.api.contstans.tanks;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public interface StatisticConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/tanks/stats";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM, EXTRA_PARAM, IN_GARAGE_PARAM, TANK_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, ACCOUNT_ID_PARAM);

}
