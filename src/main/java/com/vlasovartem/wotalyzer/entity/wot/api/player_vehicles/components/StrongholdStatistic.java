package com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.components;

import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.BasicStatistics;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class StrongholdStatistic extends BasicStatistics {

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
