package com.vlasovartem.wotalyzer.utils.enums;

/**
 * Created by artemvlasov on 14/01/16.
 */
public enum VehicleType {
    HEAVY_TANK("heavyTank"), AT_SPG("AT-SPG"), MEDIUM_TANK("mediumTank"), LIGHT_TANK("lightTank"), SPG("SPG");

    private String name;

    VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
