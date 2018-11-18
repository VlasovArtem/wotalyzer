package com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class VehicleAchievementConstants extends BasicAPIConstants {

    private static VehicleAchievementConstants constants;

    public static VehicleAchievementConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new VehicleAchievementConstants();
        }
        return constants;
    }

    private VehicleAchievementConstants() {
        super("https://api.worldoftanks.ru/wot/tanks/achievements/");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM, IN_GARAGE_PARAM, TANK_ID_PARAM));
        addRequiredParams(Collections.singletonList(ACCOUNT_ID_PARAM));
    }

}
