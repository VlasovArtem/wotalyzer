package com.vlasovartem.wotalyzer.entity.wot.api.global_map.components;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanStatistic {

    /* Battles fought */
    private int battles;
    /* Battles fought in Absolute division */
    private int battles10Level;
    /* Battles fought in Medium division */
    private int battles6Level;
    /* Battles fought in Champion division */
    private int battles8Level;
    /* Total number by provinces captured by clan */
    private int captures;
    /* Defeats */
    private int losses;
    /* Current number of captured provinces */
    private int provincesCount;
    /* Victories */
    private int wins;
    /* Victories in Absolute division */
    private int wins10Level;
    /* Victories in Medium division */
    private int wins6Level;
    /* Victories in Champion division */
    private int wins8Level;

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getBattles10Level() {
        return battles10Level;
    }

    public void setBattles10Level(int battles10Level) {
        this.battles10Level = battles10Level;
    }

    public int getBattles6Level() {
        return battles6Level;
    }

    public void setBattles6Level(int battles6Level) {
        this.battles6Level = battles6Level;
    }

    public int getBattles8Level() {
        return battles8Level;
    }

    public void setBattles8Level(int battles8Level) {
        this.battles8Level = battles8Level;
    }

    public int getCaptures() {
        return captures;
    }

    public void setCaptures(int captures) {
        this.captures = captures;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getProvincesCount() {
        return provincesCount;
    }

    public void setProvincesCount(int provincesCount) {
        this.provincesCount = provincesCount;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins10Level() {
        return wins10Level;
    }

    public void setWins10Level(int wins10Level) {
        this.wins10Level = wins10Level;
    }

    public int getWins6Level() {
        return wins6Level;
    }

    public void setWins6Level(int wins6Level) {
        this.wins6Level = wins6Level;
    }

    public int getWins8Level() {
        return wins8Level;
    }

    public void setWins8Level(int wins8Level) {
        this.wins8Level = wins8Level;
    }
}
