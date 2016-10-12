package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 */
public interface ModuleConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/encyclopedia/modules";
    /* string Нация */
    String NATION_PARAM = "nation";
    /* string Тип модуля. Допустимые значения: "vehicleRadio" — Радиостанции "vehicleEngine" — Двигатели "vehicleGun" — Орудия "vehicleChassis" — Ходовые "vehicleTurret" — Башни */
    String TYPE_PARAM = "type";
    /* string, list Дополнительные поля, которые будут включены в ответ. Допустимые значения: default_profile */
    String EXTRA_PARAM = "extra";
    /* numeric, list Идентификатор модуля. Максимальное ограничение: 100. */
    String MODULE_ID_PARAM = "module_id";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, NATION_PARAM, TYPE_PARAM, EXTRA_PARAM, MODULE_ID_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, NATION_PARAM, TYPE_PARAM);

}
