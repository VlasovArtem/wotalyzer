package com.vlasovartem.wotalyzer.utils.api.contstans.teams;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class RegularTeamConstants extends BasicAPIConstants {

    private static RegularTeamConstants constants;

    public static RegularTeamConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new RegularTeamConstants();
        }
        return constants;
    }

    private RegularTeamConstants() {
        super("https://api.worldoftanks.ru/wot/regularteams/list");
        addBasicApiConstants(Arrays.asList(LIMIT_PARAM, ORDER_BY_PARAM, PAGE_NO_PARAM, SEARCH_PARAM));
    }
    
}
