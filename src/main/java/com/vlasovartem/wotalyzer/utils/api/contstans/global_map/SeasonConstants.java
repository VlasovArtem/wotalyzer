package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonConstants extends BasicAPIConstants {

    private static SeasonConstants constants;

    public static SeasonConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new SeasonConstants();
        }
        return constants;
    }

    private SeasonConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/seasons");
        addBasicApiConstants(Arrays.asList(LIMIT_PARAM, PAGE_NO_PARAM, SEASON_ID_PARAM, STATUS_PARAM));
    }

}
