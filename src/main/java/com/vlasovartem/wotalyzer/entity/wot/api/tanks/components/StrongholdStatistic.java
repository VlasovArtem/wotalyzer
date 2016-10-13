package com.vlasovartem.wotalyzer.entity.wot.api.tanks.components;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class StrongholdStatistic extends ClanStatistic {
    
    /* Direct hits received */
    private int directHitsReceived;
    /* Hits on enemy as a result of splash damage */
    private int explosionHits;
    /* Hits received as a result of splash damage */
    private int explosionHitsReceived;
    /* Direct hits received that caused no damage */
    private int noDamageDirectHitsReceived;
    /* Penetrations */
    private int piercings;
    /* Penetrations received */
    private int piercingsReceived;
    /* Ratio of damage blocked by armor from AP, HEAT, and APCR shells to damage received from these types of shells. Value is calculated starting from version 9.0. */
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
