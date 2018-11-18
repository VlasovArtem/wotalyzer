package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonClanInfoConstants extends BasicAPIConstants {

    private static SeasonClanInfoConstants constants;

    public static SeasonClanInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new SeasonClanInfoConstants();
        }
        return constants;
    }

    private SeasonClanInfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/seasonclaninfo");
        List<String> params = Arrays.asList(CLAN_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM);
        addBasicApiConstants(params);
        addRequiredParams(params);
    }

}
