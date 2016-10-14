package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public interface EventAccountInfoConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/globalmap/eventaccountinfo";
//    /* numeric Account ID */
//    String ACCOUNT_ID_PARAM = "account_id";
//    /* string Event ID */
//    String EVENT_ID_PARAM = "event_id";
//    /* string, list Front ID. Max limit is 10. */
//    String FRONT_ID_PARAM = "front_id";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, ACCOUNT_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM);

}
