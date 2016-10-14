package com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class Defense {

    /* Total number of attacks */
    private int attacksCount;
    /* Attack efficiency */
    private float attacksEfficiency;
    /* Number of attacks in which clan has pillaged at least one enemy structure */
    private int attacksWins;
    /* Total number of battles */
    private int battlesCount;
    /* Victories/Battles ratio */
    private float battlesWinPercentage;
    /* Number of victories */
    private int battlesWins;
    /* Command Centers captured */
    private int captureBasesCount;
    /* Enemy structures pillaged */
    private int captureBuildingsCount;
    /* Industrial Resource earned */
    private int captureResourcesCount;
    /* Total number of battles for structures */
    private int clashesCount;
    /* Victories/Battles ration in battles for structures */
    private float clashesWinPercentage;
    /* Number of attacks in which clan has pillaged at least one enemy structure */
    private int clashesWins;
    /* Total number of Defenses */
    private int defensesCount;
    /* Defense efficiency */
    private float defensesEfficiency;
    /* Number of Defenses in which clan has lost no structures */
    private int defensesWins;
    /* Command Centers lost */
    private int lossBasesCount;
    /* Clan structures pillaged */
    private int lossBuildingsCount;
    /* Industrial Resource lost */
    private int lossResourcesCount;

    public int getAttacksCount() {
        return attacksCount;
    }

    public void setAttacksCount(int attacksCount) {
        this.attacksCount = attacksCount;
    }

    public float getAttacksEfficiency() {
        return attacksEfficiency;
    }

    public void setAttacksEfficiency(float attacksEfficiency) {
        this.attacksEfficiency = attacksEfficiency;
    }

    public int getAttacksWins() {
        return attacksWins;
    }

    public void setAttacksWins(int attacksWins) {
        this.attacksWins = attacksWins;
    }

    public int getBattlesCount() {
        return battlesCount;
    }

    public void setBattlesCount(int battlesCount) {
        this.battlesCount = battlesCount;
    }

    public float getBattlesWinPercentage() {
        return battlesWinPercentage;
    }

    public void setBattlesWinPercentage(float battlesWinPercentage) {
        this.battlesWinPercentage = battlesWinPercentage;
    }

    public int getBattlesWins() {
        return battlesWins;
    }

    public void setBattlesWins(int battlesWins) {
        this.battlesWins = battlesWins;
    }

    public int getCaptureBasesCount() {
        return captureBasesCount;
    }

    public void setCaptureBasesCount(int captureBasesCount) {
        this.captureBasesCount = captureBasesCount;
    }

    public int getCaptureBuildingsCount() {
        return captureBuildingsCount;
    }

    public void setCaptureBuildingsCount(int captureBuildingsCount) {
        this.captureBuildingsCount = captureBuildingsCount;
    }

    public int getCaptureResourcesCount() {
        return captureResourcesCount;
    }

    public void setCaptureResourcesCount(int captureResourcesCount) {
        this.captureResourcesCount = captureResourcesCount;
    }

    public int getClashesCount() {
        return clashesCount;
    }

    public void setClashesCount(int clashesCount) {
        this.clashesCount = clashesCount;
    }

    public float getClashesWinPercentage() {
        return clashesWinPercentage;
    }

    public void setClashesWinPercentage(float clashesWinPercentage) {
        this.clashesWinPercentage = clashesWinPercentage;
    }

    public int getClashesWins() {
        return clashesWins;
    }

    public void setClashesWins(int clashesWins) {
        this.clashesWins = clashesWins;
    }

    public int getDefensesCount() {
        return defensesCount;
    }

    public void setDefensesCount(int defensesCount) {
        this.defensesCount = defensesCount;
    }

    public float getDefensesEfficiency() {
        return defensesEfficiency;
    }

    public void setDefensesEfficiency(float defensesEfficiency) {
        this.defensesEfficiency = defensesEfficiency;
    }

    public int getDefensesWins() {
        return defensesWins;
    }

    public void setDefensesWins(int defensesWins) {
        this.defensesWins = defensesWins;
    }

    public int getLossBasesCount() {
        return lossBasesCount;
    }

    public void setLossBasesCount(int lossBasesCount) {
        this.lossBasesCount = lossBasesCount;
    }

    public int getLossBuildingsCount() {
        return lossBuildingsCount;
    }

    public void setLossBuildingsCount(int lossBuildingsCount) {
        this.lossBuildingsCount = lossBuildingsCount;
    }

    public int getLossResourcesCount() {
        return lossResourcesCount;
    }

    public void setLossResourcesCount(int lossResourcesCount) {
        this.lossResourcesCount = lossResourcesCount;
    }
}
