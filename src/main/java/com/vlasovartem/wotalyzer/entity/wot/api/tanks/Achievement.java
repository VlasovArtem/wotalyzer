package com.vlasovartem.wotalyzer.entity.wot.api.tanks;

import java.util.Map;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class Achievement {

    /* Player account ID */
    private int accountId;
    /* Achievement earned */
    private Map<String, String> achievements;
    /* Maximum values of achievement series */
    private Map<String, String> maxSeries;
    /* Current values of Achievement Series */
    private Map<String, String> series;
    /* Vehicle ID */
    private int tankId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Map<String, String> getAchievements() {
        return achievements;
    }

    public void setAchievements(Map<String, String> achievements) {
        this.achievements = achievements;
    }

    public Map<String, String> getMaxSeries() {
        return maxSeries;
    }

    public void setMaxSeries(Map<String, String> maxSeries) {
        this.maxSeries = maxSeries;
    }

    public Map<String, String> getSeries() {
        return series;
    }

    public void setSeries(Map<String, String> series) {
        this.series = series;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }
}
