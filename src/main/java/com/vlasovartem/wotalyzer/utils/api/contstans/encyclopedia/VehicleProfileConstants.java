package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class VehicleProfileConstants extends BasicAPIConstants {

    private static VehicleProfileConstants constants;

    public static VehicleProfileConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new VehicleProfileConstants();
        }
        return constants;
    }

    private VehicleProfileConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/vehicleprofile/");
        addBasicApiConstants(Arrays.asList(ENGINE_ID_PARAM, GUN_ID_PARAM, SUSPENSION_ID_PARAM, TURRET_ID_PARAM, RADIO_ID_PARAM, PROFILE_ID_PARAM, TANK_ID_PARAM));
        addRequiredParams(Collections.singletonList(TANK_ID_PARAM));
    }
    
}
