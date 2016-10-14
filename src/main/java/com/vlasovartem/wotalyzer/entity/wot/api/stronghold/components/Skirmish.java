package com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class Skirmish {

    /* Total number of Skirmishes */
    private int battlesCount;
    /* Number of defeats in Skirmishes */
    private int battlesLosses;
    /* Victories/Battles ratio in Skirmishes */
    private float battlesWinPercentage;
    /* Number of victories in Skirmishes */
    private int battlesWins;
    /* Total amount of Industrial Resource earned in Skirmishes */
    private int totalResourceCapture;

    public int getBattlesCount() {
        return battlesCount;
    }

    public void setBattlesCount(int battlesCount) {
        this.battlesCount = battlesCount;
    }

    public int getBattlesLosses() {
        return battlesLosses;
    }

    public void setBattlesLosses(int battlesLosses) {
        this.battlesLosses = battlesLosses;
    }

    public float getBattlesWinPercentage() {
        return battlesWinPercentage;
    }

    public void setBattlesWinPercentage(float battlesWinPercentage) {
        this.battlesWinPercentage = battlesWinPercentage;
    }

    public int getBattlesWins() {
        return battlesWins;
    }

    public void setBattlesWins(int battlesWins) {
        this.battlesWins = battlesWins;
    }

    public int getTotalResourceCapture() {
        return totalResourceCapture;
    }

    public void setTotalResourceCapture(int totalResourceCapture) {
        this.totalResourceCapture = totalResourceCapture;
    }
}
