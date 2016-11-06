package com.vlasovartem.wotalyzer.utils.api.contstans.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public interface PlayerAchievementsConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/achievements/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, ACCOUNT_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, ACCOUNT_ID_PARAM);

}
