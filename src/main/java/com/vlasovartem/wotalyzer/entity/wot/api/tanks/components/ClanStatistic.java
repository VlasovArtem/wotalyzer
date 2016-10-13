package com.vlasovartem.wotalyzer.entity.wot.api.tanks.components;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class ClanStatistic extends MainStatistic {

    /* Maximum Damage caused per battle */
    private int maxDamage;
    /* Maximum destroyed in battle */
    private int maxFrags;
    /* Maximum experience per battle */
    private int maxXp;

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxFrags() {
        return maxFrags;
    }

    public void setMaxFrags(int maxFrags) {
        this.maxFrags = maxFrags;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }
}
