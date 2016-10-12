package com.vlasovartem.wotalyzer.utils.validators.tankopedia;

import java.util.Arrays;
import java.util.List;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class DataValidator {

    public static boolean validateType (String value) {
        List<String> types = Arrays.asList("vehicleRadio", "vehicleEngine", "vehicleGun", "vehicleChassis", "vehicleTurret");
        return types.stream().anyMatch(s -> s.equalsIgnoreCase(value));
    }

    public static boolean validateModuleId (int moduleID) {
        return moduleID > 0 && moduleID <= 100;
    }

}
