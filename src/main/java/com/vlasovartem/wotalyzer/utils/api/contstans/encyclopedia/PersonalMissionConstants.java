package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 10/10/16.
 */
public interface PersonalMissionConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/encyclopedia/personalmissions";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CAMPAIGN_ID_PARAM, OPERATION_ID_PARAM, SET_ID_PARAM, TAG_PARAM);

}
