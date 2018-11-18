package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonRatingConstants extends BasicAPIConstants {

    private static SeasonRatingConstants constants;

    public static SeasonRatingConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new SeasonRatingConstants();
        }
        return constants;
    }

    private SeasonRatingConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/seasonrating");
        addBasicApiConstants(Arrays.asList(SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM, LIMIT_PARAM, PAGE_NO_PARAM));
        addRequiredParams(Arrays.asList(SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM));
    }

}
