package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCESS_TOKEN_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.CLAN_ID_PARAM;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public interface ClanInfoConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/globalmap/claninfo";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CLAN_ID_PARAM, ACCESS_TOKEN_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, CLAN_ID_PARAM);

}
