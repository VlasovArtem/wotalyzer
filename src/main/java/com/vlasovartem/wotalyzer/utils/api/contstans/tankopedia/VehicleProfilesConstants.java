package com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
public interface VehicleProfilesConstants extends VehicleBasicConstants {

    /* string Сортировка. Допустимые значения: "price_credit" — по стоимости в кредитах "-price_credit" — по стоимости в кредитах, в обратном порядке */
    String ORDER_BY_PARAM = "order_by";

    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, TANK_ID_PARAM, ORDER_BY_PARAM);

}
