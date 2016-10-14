package com.vlasovartem.wotalyzer.utils.validators.global_map;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class GlobalMapValidator {

    public static boolean validateFrontIdParameter (Object value) {
        return !(value instanceof List) || ((List) value).size() >= 10;
    }

}
