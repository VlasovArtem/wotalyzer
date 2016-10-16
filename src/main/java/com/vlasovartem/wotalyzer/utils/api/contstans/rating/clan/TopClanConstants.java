package com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public interface TopClanConstants extends BasicAPIConstants {

    String BASIC_URL = "https://api.worldoftanks.ru/wot/clanratings/top";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, RANK_FIELD_PARAM, DATE_PARAM, LIMIT_PARAM, PAGE_NO_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, RANK_FIELD_PARAM);

}
