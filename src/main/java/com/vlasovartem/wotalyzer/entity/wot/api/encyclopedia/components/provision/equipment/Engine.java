package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment;

import com.vlasovartem.wotalyzer.entity.wot.api.MainEntityExt;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Engine extends MainEntityExt {

    private float fireChance;
    private int power;

    public float getFireChance() {
        return fireChance;
    }

    public void setFireChance(float fireChance) {
        this.fireChance = fireChance;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
