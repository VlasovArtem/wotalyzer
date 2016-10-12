package com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public interface TopClanConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/clanratings/top";
    /* string Категория рейтинга */
    String RANK_FIELD_PARAM = "rank_field";
    /* timestamp/date Дата расчёта рейтингов. Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00 */
    String DATE_PARAM = "date";
    /* numeric Количество возвращаемых записей (может вернуться меньше записей, но не больше 1000). Если переданный лимит превышает 1000, тогда автоматически выставляется лимит в 10 (по умолчанию). */
    String LIMIT_PARAM = "limit";
    /* numeric Номер страницы */
    String PAGE_NO_PARAM = "page_no";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, RANK_FIELD_PARAM, DATE_PARAM, LIMIT_PARAM, PAGE_NO_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, RANK_FIELD_PARAM);

}
