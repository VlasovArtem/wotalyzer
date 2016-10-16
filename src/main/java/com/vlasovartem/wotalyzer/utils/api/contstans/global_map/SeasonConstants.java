package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public interface SeasonConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/globalmap/seasons";
//    /* numeric Page limit. Default is 5. Max value is 20. Min value is 1. */
//    String LIMIT_PARAM = "limit";
//    /* numeric Page number. Default is 1. Min value is 1. */
//    String PAGE_NO_PARAM = "page_no";
//    /* string Season ID */
//    String SEASON_ID_PARAM = "season_id";
//    /* string Response with seasons filtered by status. Valid values: "PLANNED" — Upcoming season "ACTIVE" — Current season "FINISHED" — Season is over */
//    String STATUS_PARAM = "status";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, LIMIT_PARAM, PAGE_NO_PARAM, SEASON_ID_PARAM, STATUS_PARAM);

}
