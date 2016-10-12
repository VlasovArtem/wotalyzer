package com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.components;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class ModulesTree {
    private long moduleId;
    @JsonProperty("is_default")
    private boolean isDefault;
    private String name;
    private List<Integer> nextModules;
    private List<Integer> nextTanks;
    private int priceCredit;
    private int priceXp;
    private String type;

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNextModules() {
        return nextModules;
    }

    public void setNextModules(List<Integer> nextModules) {
        this.nextModules = nextModules;
    }

    public List<Integer> getNextTanks() {
        return nextTanks;
    }

    public void setNextTanks(List<Integer> nextTanks) {
        this.nextTanks = nextTanks;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getPriceXp() {
        return priceXp;
    }

    public void setPriceXp(int priceXp) {
        this.priceXp = priceXp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
