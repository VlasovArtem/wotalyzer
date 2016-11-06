package com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.components.MainStatistic;

/**
 * Created by artemvlasov on 10/09/16.
 */
public class BasicStatistics extends MainStatistic {

    /* Количество полученных прямых попаданий */
    private int directHitsReceived;
    /* Количество нанесённых осколочно-фугасных попаданий */
    private int explosionHits;
    /* Количество полученных осколочно-фугасных попаданий */
    private int explosionHitsReceived;
    /* Количество полученных прямых попаданий, не нанёсших урон */
    private int noDamageDirectHitsReceived;
    /* Количество пробитий */
    private int piercings;
    /* Количество полученных пробитий */
    private int piercingsReceived;
    /* Отношение заблокированного бронёй урона к полученному игроком урону от бронебойных, кумулятивных, подкалиберных снарядов. Значение считается с версии игры 9.0. */
    private float tankingFactor;

    public int getDirectHitsReceived() {
        return directHitsReceived;
    }

    public void setDirectHitsReceived(int directHitsReceived) {
        this.directHitsReceived = directHitsReceived;
    }

    public int getExplosionHits() {
        return explosionHits;
    }

    public void setExplosionHits(int explosionHits) {
        this.explosionHits = explosionHits;
    }

    public int getExplosionHitsReceived() {
        return explosionHitsReceived;
    }

    public void setExplosionHitsReceived(int explosionHitsReceived) {
        this.explosionHitsReceived = explosionHitsReceived;
    }

    public int getNoDamageDirectHitsReceived() {
        return noDamageDirectHitsReceived;
    }

    public void setNoDamageDirectHitsReceived(int noDamageDirectHitsReceived) {
        this.noDamageDirectHitsReceived = noDamageDirectHitsReceived;
    }

    public int getPiercings() {
        return piercings;
    }

    public void setPiercings(int piercings) {
        this.piercings = piercings;
    }

    public int getPiercingsReceived() {
        return piercingsReceived;
    }

    public void setPiercingsReceived(int piercingsReceived) {
        this.piercingsReceived = piercingsReceived;
    }

    public float getTankingFactor() {
        return tankingFactor;
    }

    public void setTankingFactor(float tankingFactor) {
        this.tankingFactor = tankingFactor;
    }
}
