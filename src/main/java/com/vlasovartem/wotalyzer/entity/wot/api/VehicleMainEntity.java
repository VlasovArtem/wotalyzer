package com.vlasovartem.wotalyzer.entity.wot.api;

/**
 * Created by artemvlasov on 10/10/16.
 */
public abstract class VehicleMainEntity extends MainEntity {

    private int tier;
    private int weight;

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

}
