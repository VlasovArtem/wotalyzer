package com.vlasovartem.wotalyzer.utils.api.contstans.player;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 28/09/16.
 */
public interface PlayerBasicConstants extends BasicAPIConstants {

    String ACCOUNT_ID_PARAM = "account_id";
    String ACCESS_TOKEN_PARAM = "access_token";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM);

}
