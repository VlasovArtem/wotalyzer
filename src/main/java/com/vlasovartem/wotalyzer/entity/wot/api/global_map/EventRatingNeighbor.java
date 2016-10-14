package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventRatingNeighbor {

    /* Award level */
    private String awardLevel;
    /* Battle Fame points */
    private int battleFamePoints;
    /* Clan ID */
    private int clanId;
    /* Clan color */
    private String color;
    /* Amount of Fame points needed to improve personal award */
    private int famePointsToImproveAward;
    /* Clan name */
    private String name;
    /* Current rating */
    private int rank;
    /* Rating changes during previous turn */
    private int rankDelta;
    /* Clan tag */
    private String tag;
    /* Mission Fame points */
    private int taskFamePoints;
    /* Total Fame points */
    private int totalFamePoints;
    /* Date of rating calculation */
    private LocalDateTime updatedAt;

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public int getBattleFamePoints() {
        return battleFamePoints;
    }

    public void setBattleFamePoints(int battleFamePoints) {
        this.battleFamePoints = battleFamePoints;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFamePointsToImproveAward() {
        return famePointsToImproveAward;
    }

    public void setFamePointsToImproveAward(int famePointsToImproveAward) {
        this.famePointsToImproveAward = famePointsToImproveAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRankDelta() {
        return rankDelta;
    }

    public void setRankDelta(int rankDelta) {
        this.rankDelta = rankDelta;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTaskFamePoints() {
        return taskFamePoints;
    }

    public void setTaskFamePoints(int taskFamePoints) {
        this.taskFamePoints = taskFamePoints;
    }

    public int getTotalFamePoints() {
        return totalFamePoints;
    }

    public void setTotalFamePoints(int totalFamePoints) {
        this.totalFamePoints = totalFamePoints;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
