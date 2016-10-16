package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public interface EventClanInfoConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/globalmap/eventclaninfo";
//    /* numeric Clan ID */
//    String CLAN_ID_PARAM = "clan_id";
//    /* string Event ID */
//    String EVENT_ID_PARAM = "event_id";
//    /* string, list Front ID. Max limit is 10. */
//    String FRONT_ID_PARAM = "front_id";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CLAN_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, CLAN_ID_PARAM, EVENT_ID_PARAM, FRONT_ID_PARAM);

}
