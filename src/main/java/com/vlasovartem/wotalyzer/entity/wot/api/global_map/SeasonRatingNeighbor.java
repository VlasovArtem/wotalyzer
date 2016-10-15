package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class SeasonRatingNeighbor {

    /* Award level */
    private String awardLevel;
    /* Clan ID */
    private int clanId;
    /* Clan color */
    private String color;
    /* Clan name */
    private String name;
    /* Current rating */
    private int rank;
    /* Rating changes during previous turn */
    private int rankDelta;
    /* Clan tag */
    private String tag;
    /* Date of rating calculation */
    private LocalDateTime updatedAt;
    /* Victory points */
    private int victoryPoints;
    /* Victory points to get the next award */
    private int victoryPointsToNextAward;

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public int getVictoryPointsToNextAward() {
        return victoryPointsToNextAward;
    }

    public void setVictoryPointsToNextAward(int victoryPointsToNextAward) {
        this.victoryPointsToNextAward = victoryPointsToNextAward;
    }
}
