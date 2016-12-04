package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 20/11/2016.
 */
public enum ModuleType {

    RADIO("vehicleRadio"), ENGINE("vehicleEngine"), GUN("vehicleGun"), SUSPENSION("vehicleChassis"), TURRET("vehicleTurret");

    private String value;

    ModuleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
