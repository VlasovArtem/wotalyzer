package com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class VehicleStatisticConstants extends BasicAPIConstants {

    private static VehicleStatisticConstants constants;

    public static VehicleStatisticConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new VehicleStatisticConstants();
        }
        return constants;
    }

    private VehicleStatisticConstants() {
        super("https://api.worldoftanks.ru/wot/tanks/stats");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM, EXTRA_PARAM, IN_GARAGE_PARAM, TANK_ID_PARAM));
        addRequiredParams(Arrays.asList(ACCOUNT_ID_PARAM));
    }

}
