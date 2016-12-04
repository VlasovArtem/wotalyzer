package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 27/11/2016.
 */
public enum BattleType {

    COMPANY("company"), RANDOM("random"), TEAM("team"), DEFAULT_TYPE("default");


    private final String value;

    BattleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
