package com.vlasovartem.wotalyzer.utils.api.contstans.rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public interface RatingDateConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/ratings/dates";
    /* string Период формирования рейтинга */
    String TYPE_PARAM = "type";
    /* numeric, list Идентификатор аккаунта игрока */
    String ACCOUNT_ID_PARAM = "account_id";
    /* string Типы боёв. Допустимые значения: "company" — Ротные бои "random" — Случайные бои "team" — Командные бои "default" — без учёта типа боя (используется по умолчанию) */
    String BATTLE_TYPE_PARAM = "battle_type";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, TYPE_PARAM, ACCOUNT_ID_PARAM, BATTLE_TYPE_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, TYPE_PARAM);

}
