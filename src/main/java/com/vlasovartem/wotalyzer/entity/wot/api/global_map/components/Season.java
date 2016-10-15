package com.vlasovartem.wotalyzer.entity.wot.api.global_map.components;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class Season {
    /* Battles fought */
    private int battles;
    /* Elo rating */
    private int elo;
    /* Current rating */
    private int rank;
    /* Rating changes during previous turn */
    private int rankDelta;
    /* Vehicle Tier */
    private int vehicleLevel;
    /* Victory points */
    private int victoryPoints;
    /* Change of Victory points since last turn calculation */
    private int victoryPointsSinceTurn;
    /* Victories */
    private int wins;

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
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

    public int getVehicleLevel() {
        return vehicleLevel;
    }

    public void setVehicleLevel(int vehicleLevel) {
        this.vehicleLevel = vehicleLevel;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public int getVictoryPointsSinceTurn() {
        return victoryPointsSinceTurn;
    }

    public void setVictoryPointsSinceTurn(int victoryPointsSinceTurn) {
        this.victoryPointsSinceTurn = victoryPointsSinceTurn;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
