package com.vlasovartem.wotalyzer.entity.wot.api.global_map.components;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class Event {

    /* Account ID */
    private int accountId;
    /* Award level */
    private String awardLevel;
    /* Battles fought for current clan */
    private int battles;
    /* Battles to fight in a current clan to get clan award for the season */
    private int battlesToAward;
    /* Clan ID */
    private int clanId;
    /* Clan rating */
    private int clanRank;
    /* Event ID */
    private String eventId;
    /* Fame points */
    private int famePoints;
    /* Change of Fame points since last turn calculation */
    private int famePointsSinceTurn;
    /* Amount of Fame points needed to improve personal award */
    private int famePointsToImproveAward;
    /* Front ID */
    private String frontId;
    /* Current rating */
    private int rank;
    /* Rating changes during previous turn */
    private int rankDelta;
    /* Date when account data were updated */
    private LocalDateTime updatedAt;
    /* Link to Front */
    private String url;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getBattlesToAward() {
        return battlesToAward;
    }

    public void setBattlesToAward(int battlesToAward) {
        this.battlesToAward = battlesToAward;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public int getClanRank() {
        return clanRank;
    }

    public void setClanRank(int clanRank) {
        this.clanRank = clanRank;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getFamePoints() {
        return famePoints;
    }

    public void setFamePoints(int famePoints) {
        this.famePoints = famePoints;
    }

    public int getFamePointsSinceTurn() {
        return famePointsSinceTurn;
    }

    public void setFamePointsSinceTurn(int famePointsSinceTurn) {
        this.famePointsSinceTurn = famePointsSinceTurn;
    }

    public int getFamePointsToImproveAward() {
        return famePointsToImproveAward;
    }

    public void setFamePointsToImproveAward(int famePointsToImproveAward) {
        this.famePointsToImproveAward = famePointsToImproveAward;
    }

    public String getFrontId() {
        return frontId;
    }

    public void setFrontId(String frontId) {
        this.frontId = frontId;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
