package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public interface ProvinceConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/globalmap/provinces";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, FRONT_ID_PARAM, ARENA_ID_PARAM, DAILY_REVENUE_GTE_PARAM, DAILY_REVENUE_LTE_PARAM, LANDING_TYPE_PARAM, LIMIT_PARAM, ORDER_BY_PARAM, PAGE_NO_PARAM, PRIME_HOUR_PARAM, PROVINCE_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, FRONT_ID_PARAM);

}
