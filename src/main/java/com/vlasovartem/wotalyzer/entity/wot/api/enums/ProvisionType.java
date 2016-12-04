package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public enum ProvisionType {
    CONSUMABLES("equipment"), EQUIPMENT("optionalDevice");

    private String value;

    ProvisionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
