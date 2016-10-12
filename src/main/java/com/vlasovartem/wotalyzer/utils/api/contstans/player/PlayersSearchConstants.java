package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayersSearchConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/list/";
    String SEARCH_PARAM = "search";
    String LIMIT_PARAM = "limit";
    String TYPE_PARAM = "type";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, SEARCH_PARAM, LIMIT_PARAM, TYPE_PARAM);

}
