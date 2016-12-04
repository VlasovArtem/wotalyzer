package com.vlasovartem.wotalyzer.utils.api.contstans.teams;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TEAM_ID;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public interface RegularTeamInfoConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/regularteams/info";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, TEAM_ID);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, TEAM_ID);

}
