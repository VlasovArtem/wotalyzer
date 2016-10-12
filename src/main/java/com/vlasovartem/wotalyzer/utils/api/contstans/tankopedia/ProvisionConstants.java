package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
public interface ProvisionConstants extends BasicAPIConstants {

    String PROVISION_ID_PARAM = "provision_id";
    String TYPE_PARAM = "type";
    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/encyclopedia/provisions";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, PROVISION_ID_PARAM, TYPE_PARAM);

}
