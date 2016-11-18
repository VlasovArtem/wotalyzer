package com.vlasovartem.wotalyzer.utils.api.contstans.enums;

/**
 * Created by artemvlasov on 16/11/2016.
 */
public enum NameTypeParameter {

    EXACT("exact"), START_WITH("startwith");

    NameTypeParameter(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
