package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ORDER_BY_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class VehicleConfigurationConstants extends BasicAPIConstants {

    private static VehicleConfigurationConstants constants;

    public static VehicleConfigurationConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new VehicleConfigurationConstants();
        }
        return constants;
    }

    private VehicleConfigurationConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/vehicles/");
        addBasicApiConstants(Arrays.asList(TANK_ID_PARAM, ORDER_BY_PARAM));
    }
    

}
