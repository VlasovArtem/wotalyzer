package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonAccountInfoConstants extends BasicAPIConstants {

    private static SeasonAccountInfoConstants constants;

    public static SeasonAccountInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new SeasonAccountInfoConstants();
        }
        return constants;
    }

    private SeasonAccountInfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/seasonaccountinfo");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM));
        addRequiredParams(Arrays.asList(ACCOUNT_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM));
    }

}
