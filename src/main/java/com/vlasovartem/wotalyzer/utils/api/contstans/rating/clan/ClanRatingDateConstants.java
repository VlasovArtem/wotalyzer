package com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public interface ClanRatingDateConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/clanratings/dates";
    /* numeric Количество возвращаемых записей (может вернуться меньше записей, но не больше 365). Если переданный лимит превышает 365, тогда автоматически выставляется лимит в 7 (по умолчанию). */
    String LIMIT_PARAM = "limit";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, LIMIT_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS);

}
