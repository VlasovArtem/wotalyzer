package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 13/12/2016.
 */
public enum GameType {

    WOT("wot"), WOWP("wowp");


    private final String value;

    GameType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
