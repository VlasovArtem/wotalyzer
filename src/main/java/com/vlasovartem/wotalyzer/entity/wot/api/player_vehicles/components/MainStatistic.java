package com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.components;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class MainStatistic {

    /* Average experience per battle */
    private int battleAvgXp;
    /* Battles fought */
    private long battles;
    /* Base capture points */
    private long capturePoints;
    /* Damage caused */
    private long damageDealt;
    /* Damage received */
    private long damageReceived;
    /* Draws */
    private int draws;
    /* Base defense points */
    private int droppedCapturePoints;
    /* VehicleConfiguration destroyed */
    private int frags;
    /* Hits */
    private int hits;
    /* Hit ratio */
    private int hitsPercents;
    /* Defeats */
    private int losses;
    /* Shots fired */
    private int shots;
    /* Enemies spotted */
    private int spotted;
    /* Battles survived */
    private int survivedBattles;
    /* Victories */
    private int wins;
    /* Total experience */
    private int xp;

    public int getBattleAvgXp() {
        return battleAvgXp;
    }

    public void setBattleAvgXp(int battleAvgXp) {
        this.battleAvgXp = battleAvgXp;
    }

    public long getBattles() {
        return battles;
    }

    public void setBattles(long battles) {
        this.battles = battles;
    }

    public long getCapturePoints() {
        return capturePoints;
    }

    public void setCapturePoints(long capturePoints) {
        this.capturePoints = capturePoints;
    }

    public long getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(long damageDealt) {
        this.damageDealt = damageDealt;
    }

    public long getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(long damageReceived) {
        this.damageReceived = damageReceived;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDroppedCapturePoints() {
        return droppedCapturePoints;
    }

    public void setDroppedCapturePoints(int droppedCapturePoints) {
        this.droppedCapturePoints = droppedCapturePoints;
    }

    public int getFrags() {
        return frags;
    }

    public void setFrags(int frags) {
        this.frags = frags;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHitsPercents() {
        return hitsPercents;
    }

    public void setHitsPercents(int hitsPercents) {
        this.hitsPercents = hitsPercents;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getSpotted() {
        return spotted;
    }

    public void setSpotted(int spotted) {
        this.spotted = spotted;
    }

    public int getSurvivedBattles() {
        return survivedBattles;
    }

    public void setSurvivedBattles(int survivedBattles) {
        this.survivedBattles = survivedBattles;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
