package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class VehicleConstants extends BasicAPIConstants {

    private static VehicleConstants constants;

    public static VehicleConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new VehicleConstants();
        }
        return constants;
    }

    private VehicleConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/vehicles/");
        addBasicApiConstants(Arrays.asList(NATION_PARAM, TIER_PARAM, TYPE_PARAM, TANK_ID_PARAM));
    }

}
