package com.vlasovartem.wotalyzer.utils.api.contstans.enums;

/**
 * Created by artemvlasov on 17/11/2016.
 */
public enum RatingTypeParameter {

    TYPE_1("1"), TYPE_7("7"), TYPE_28("28"), TYPE_ALL("all");

    RatingTypeParameter(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
