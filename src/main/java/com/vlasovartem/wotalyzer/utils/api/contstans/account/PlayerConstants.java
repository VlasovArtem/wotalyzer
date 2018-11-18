package com.vlasovartem.wotalyzer.utils.api.contstans.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 28/09/16.
 */
public class PlayerConstants extends BasicAPIConstants {

    private static PlayerConstants constants;

    public static PlayerConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PlayerConstants();
        }
        return constants;
    }

    private PlayerConstants() {
        super("https://api.worldoftanks.ru/wot/account/info/");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM, EXTRA_PARAM));
        addRequiredParams(Collections.singletonList(ACCOUNT_ID_PARAM));
    }

}
