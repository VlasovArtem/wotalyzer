package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vlasovartem.wotalyzer.entity.wot.api.Entity;

import java.util.Map;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerAchievements extends Entity {

    /* Achievement earned */
    private Map<String, Integer> achievements;
    /* Achievement progress */
    private Map<String, Integer> frags;
    /* Maximum values of achievement series */
    private Map<String, Integer> maxSeries;

    public Map<String, Integer> getAchievements() {
        return achievements;
    }

    public void setAchievements(Map<String, Integer> achievements) {
        this.achievements = achievements;
    }

    public Map<String, Integer> getFrags() {
        return frags;
    }

    public void setFrags(Map<String, Integer> frags) {
        this.frags = frags;
    }

    public Map<String, Integer> getMaxSeries() {
        return maxSeries;
    }

    public void setMaxSeries(Map<String, Integer> maxSeries) {
        this.maxSeries = maxSeries;
    }
}
