package com.vlasovartem.wotalyzer.utils.api.contstans.rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public interface TypeConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/ratings/types";
    /* string Типы боёв. Допустимые значения: "company" — Ротные бои "random" — Случайные бои "team" — Командные бои "default" — без учёта типа боя (используется по умолчанию) */
    String BATTLE_TYPE_PARAM = "battle_type";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, BATTLE_TYPE_PARAM);

}
