package com.vlasovartem.wotalyzer.entity.wot.api.tanks.components;

import com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics.BasicStatistics;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class OverallStatistic extends BasicStatistics {

    /* Average damage blocked by armor per battle. Damage blocked by armor is damage received from shells (AP, HEAT and APCR) that hit a vehicle but caused no damage. Value is calculated starting from version 9.0. */
    private float avgDamageBlocked;

    public float getAvgDamageBlocked() {
        return avgDamageBlocked;
    }

    public void setAvgDamageBlocked(float avgDamageBlocked) {
        this.avgDamageBlocked = avgDamageBlocked;
    }

}
