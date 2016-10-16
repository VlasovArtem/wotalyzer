package com.vlasovartem.wotalyzer.entity.wot.api;

/**
 * Created by artemvlasov on 10/10/16.
 */
public abstract class MainEntityExt extends MainEntity {

    private String tag;
    private int tier;
    private int weight;
    private String name;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
