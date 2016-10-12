package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayersSearchConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/list/";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, SEARCH_PARAM, LIMIT_PARAM, TYPE_PARAM);

}
