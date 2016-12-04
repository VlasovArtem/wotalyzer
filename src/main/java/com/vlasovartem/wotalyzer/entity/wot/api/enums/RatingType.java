package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 17/11/2016.
 */
public enum RatingType {

    TYPE_1("1"), TYPE_7("7"), TYPE_28("28"), TYPE_ALL("all");

    RatingType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
