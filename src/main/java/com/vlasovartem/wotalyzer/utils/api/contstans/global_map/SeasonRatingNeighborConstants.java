package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonRatingNeighborConstants extends BasicAPIConstants {

    private static SeasonRatingNeighborConstants constants;

    public static SeasonRatingNeighborConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new SeasonRatingNeighborConstants();
        }
        return constants;
    }

    private SeasonRatingNeighborConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/seasonratingneighbors");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM, LIMIT_PARAM));
        addRequiredParams(Arrays.asList(CLAN_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM));
    }

}
