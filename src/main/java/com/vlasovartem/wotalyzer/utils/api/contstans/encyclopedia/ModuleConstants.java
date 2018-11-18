package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 11/10/16.
 */
public class ModuleConstants extends BasicAPIConstants {

    private static ModuleConstants constants;

    public static ModuleConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ModuleConstants();
        }
        return constants;
    }

    private ModuleConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/modules/");
        addBasicApiConstants(Arrays.asList(NATION_PARAM, TYPE_PARAM, EXTRA_PARAM, MODULE_ID_PARAM));
        addRequiredParams(Arrays.asList(NATION_PARAM, TYPE_PARAM));
    }
}
