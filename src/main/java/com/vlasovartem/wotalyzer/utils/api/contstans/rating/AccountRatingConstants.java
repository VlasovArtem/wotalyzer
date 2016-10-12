package com.vlasovartem.wotalyzer.utils.api.contstans.rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public interface AccountRatingConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/ratings/accounts";
    /* numeric, list Идентификаторы аккаунтов игроков */
    String ACCOUNT_ID_PARAM = "account_id";
    /* string Период формирования рейтинга */
    String TYPE_PARAM = "type";
    /* string Типы боёв. Допустимые значения: "company" — Ротные бои "random" — Случайные бои "team" — Командные бои "default" — без учёта типа боя (используется по умолчанию) */
    String BATTLE_TYPE_PARAM = "battle_type";
    /* timestamp/date Дата расчёта рейтингов. Не больше, чем 7 дней до текущей даты; по умолчанию - вчера. Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00 */
    String DATE_PARAM = "date";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, TYPE_PARAM, ACCOUNT_ID_PARAM, BATTLE_TYPE_PARAM, DATE_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, TYPE_PARAM, ACCOUNT_ID_PARAM);

}
