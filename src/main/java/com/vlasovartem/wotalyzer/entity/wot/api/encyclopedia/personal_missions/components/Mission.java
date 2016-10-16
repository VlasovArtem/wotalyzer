package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.personal_missions.components;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 * Задачи операции
 */
public class Mission {

    /* Описание задачи */
    private String description;
    /* Советы */
    private String hint;
    /* Максимальный уровень техники */
    private int maxLevel;
    /* Минимальный уровень техники */
    private int minLevel;
    /* Идентификатор задачи */
    private int missionId;
    /* Название задачи */
    private String name;
    /* Идентификатор ветки задач */
    private int setId;
    /* Теги задачи */
    private List<String> tags;
    /* Награды, сгруппированые по условию задачи */
    private List<MissionReward> rewards;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<MissionReward> getRewards() {
        return rewards;
    }

    public void setRewards(List<MissionReward> rewards) {
        this.rewards = rewards;
    }
}
