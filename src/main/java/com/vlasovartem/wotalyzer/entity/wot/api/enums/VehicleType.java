package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public enum VehicleType {
    HEAVY_TANK("heavyTank"), TANK_DESTROYER("AT-SPG"), MEDIUM_TANK("mediumTank"), LIGHT_TANK("lightTank"), SPG("SPG");

    private String value;

    VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
