package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class FrontConstants extends BasicAPIConstants {

    private static FrontConstants constants;

    public static FrontConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new FrontConstants();
        }
        return constants;
    }

    private FrontConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/fronts");
        addBasicApiConstants(Arrays.asList(FRONT_ID_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
    }

}
