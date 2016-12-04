package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.Entity;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.achievements.Frags;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.achievements.MaxSeries;

import java.util.Map;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlayerAchievements extends Entity {

    /* VehicleAchievement earned */
    private Map<String, Integer> achievements;
    /* VehicleAchievement progress */
    private Frags frags;
    /* Maximum values of achievement series */
    private MaxSeries maxSeries;

    public Map<String, Integer> getAchievements() {
        return achievements;
    }

    public void setAchievements(Map<String, Integer> achievements) {
        this.achievements = achievements;
    }

    public Frags getFrags() {
        return frags;
    }

    public void setFrags(Frags frags) {
        this.frags = frags;
    }

    public MaxSeries getMaxSeries() {
        return maxSeries;
    }

    public void setMaxSeries(MaxSeries maxSeries) {
        this.maxSeries = maxSeries;
    }
}
