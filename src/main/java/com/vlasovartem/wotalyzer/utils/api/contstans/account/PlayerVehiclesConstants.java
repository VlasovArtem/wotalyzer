package com.vlasovartem.wotalyzer.utils.api.contstans.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlayerVehiclesConstants extends BasicAPIConstants{

    private static PlayerVehiclesConstants constants;

    public static PlayerVehiclesConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PlayerVehiclesConstants();
        }
        return constants;
    }

    private PlayerVehiclesConstants() {
        super("https://api.worldoftanks.ru/wot/account/tanks/");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM, TANK_ID_PARAM));
        addRequiredParams(Collections.singletonList(ACCOUNT_ID_PARAM));
    }

}
