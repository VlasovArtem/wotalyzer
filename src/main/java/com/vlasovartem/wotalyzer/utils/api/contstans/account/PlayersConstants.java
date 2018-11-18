package com.vlasovartem.wotalyzer.utils.api.contstans.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlayersConstants extends BasicAPIConstants {

    private static PlayersConstants constants;

    public static PlayersConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PlayersConstants();
        }
        return constants;
    }

    private PlayersConstants() {
        super("https://api.worldoftanks.ru/wot/account/list/");
        addBasicApiConstants(Arrays.asList(SEARCH_PARAM, LIMIT_PARAM, TYPE_PARAM));
        addRequiredParams(Collections.singletonList(SEARCH_PARAM));
    }

}
