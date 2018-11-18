package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ProvinceConstants extends BasicAPIConstants {

    private static ProvinceConstants constants;

    public static ProvinceConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ProvinceConstants();
        }
        return constants;
    }

    private ProvinceConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/provinces");
        addBasicApiConstants(Arrays.asList(FRONT_ID_PARAM, ARENA_ID_PARAM, DAILY_REVENUE_GTE_PARAM, DAILY_REVENUE_LTE_PARAM, LANDING_TYPE_PARAM, LIMIT_PARAM, ORDER_BY_PARAM, PAGE_NO_PARAM, PRIME_HOUR_PARAM, PROVINCE_ID_PARAM));
        addRequiredParams(Collections.singletonList(FRONT_ID_PARAM));
    }

}
