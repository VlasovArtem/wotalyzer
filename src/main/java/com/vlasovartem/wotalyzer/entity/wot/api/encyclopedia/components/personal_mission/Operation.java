package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_mission;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vlasovartem.wotalyzer.deserializers.MissionDeserializer;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 * Операции кампании
 */
public class Operation {

    /* Описание операции */
    private String description;
    /* Ссылка на изображение операции */
    private String image;
    /* Количество задач в ветке */
    private int missionsInSet;
    /* Название операции */
    private String name;
    /* Идентификатор следующей операции */
    private int nextId;
    /* Идентификатор операции */
    private int operationId;
    /* Количество веток задач операции */
    private int setsCount;
    /* Количество веток до следующей операции */
    private int setsToNext;
    /* Задачи операции */
    @JsonDeserialize(using = MissionDeserializer.class)
    private List<Mission> missions;
    /* Награда за операцию */
    private OperationReward reward;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMissionsInSet() {
        return missionsInSet;
    }

    public void setMissionsInSet(int missionsInSet) {
        this.missionsInSet = missionsInSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getSetsCount() {
        return setsCount;
    }

    public void setSetsCount(int setsCount) {
        this.setsCount = setsCount;
    }

    public int getSetsToNext() {
        return setsToNext;
    }

    public void setSetsToNext(int setsToNext) {
        this.setsToNext = setsToNext;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public OperationReward getReward() {
        return reward;
    }

    public void setReward(OperationReward reward) {
        this.reward = reward;
    }
}
