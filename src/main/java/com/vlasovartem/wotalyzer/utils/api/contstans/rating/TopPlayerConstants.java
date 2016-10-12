package com.vlasovartem.wotalyzer.utils.api.contstans.rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public interface TopPlayerConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/ratings/top";
    /* string Категория рейтинга */
    String RANK_FIELD_PARAM = "rank_field";
    /* string Период формирования рейтинга */
    String TYPE_PARAM = "type";
    /* string Типы боёв. Допустимые значения: "company" — Ротные бои "random" — Случайные бои "team" — Командные бои "default" — без учёта типа боя (используется по умолчанию) */
    String BATTLE_TYPE_PARAM = "battle_type";
    /* timestamp/date Дата расчёта рейтингов. Не больше, чем 7 дней до текущей даты; по умолчанию - вчера. Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00 */
    String DATE_PARAM = "date";
    /* numeric Количество возвращаемых записей. По умолчанию: 10. Максимальное значение: 1000. */
    String LIMIT_PARAM = "limit";
    /* numeric Номер страницы результатов */
    String PAGE_NO_PARAM = "page_no";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, RANK_FIELD_PARAM, TYPE_PARAM, BATTLE_TYPE_PARAM, DATE_PARAM, LIMIT_PARAM, PAGE_NO_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, RANK_FIELD_PARAM, TYPE_PARAM);

}
