package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayerConstants extends PlayerBasicConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/account/info/";
    String EXTRA_PARAM = "extra";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(PlayerBasicConstants.BASIC_API_CONSTANTS, EXTRA_PARAM);

}
