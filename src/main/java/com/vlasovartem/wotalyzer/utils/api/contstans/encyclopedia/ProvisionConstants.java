package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.PROVISION_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class ProvisionConstants extends BasicAPIConstants {

    private static ProvisionConstants constants;

    public static ProvisionConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ProvisionConstants();
        }
        return constants;
    }

    private ProvisionConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/provisions/");
        addBasicApiConstants(Arrays.asList(PROVISION_ID_PARAM, TYPE_PARAM));
    }

}
