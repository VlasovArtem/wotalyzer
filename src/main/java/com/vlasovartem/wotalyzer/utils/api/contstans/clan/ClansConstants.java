package com.vlasovartem.wotalyzer.utils.api.contstans.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 13/12/2016.
 */
public class ClansConstants extends BasicAPIConstants {

    private static ClansConstants constants;

    public static ClansConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClansConstants();
        }
        return constants;
    }

    private ClansConstants() {
        super("https://api.worldoftanks.ru/wgn/clans/list");
        addBasicApiConstants(Arrays.asList(GAME_PARAM, SEARCH_PARAM, LIMIT_PARAM));
    }

}
