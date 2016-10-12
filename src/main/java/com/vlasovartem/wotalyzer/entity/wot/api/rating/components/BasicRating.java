package com.vlasovartem.wotalyzer.entity.wot.api.rating.components;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public abstract class BasicRating {

    /* Идентификатор аккаунта игрока */
    private int accountId;
    /* Оставшееся количество боёв до участия в рейтингах */
    private int battlesToPlay;
    /* Количество проведённых боёв */
    private RatingData battlesCount;
    /* Очки захвата базы */
    private RatingData capturePoints;
    /* Средний нанесённый урон за бой */
    private RatingData damageAvg;
    /* Общий нанесённый урон */
    private RatingData damageDealt;
    /* Среднее количество уничтоженной техники за бой */
    private RatingData fragsAvg;
    /* Количество уничтоженной техники */
    private RatingData fragsCount;
    /* Личный рейтинг */
    private RatingData globalRating;
    /* Процент попаданий */
    private RatingData hitsRatio;
    /* Среднее количество обнаруженной техники за бой */
    private RatingData spottedAvg;
    /* Количество обнаруженной техники */
    private RatingData spottedCount;
    /* Процент выживаемости */
    private RatingData survivedRatio;
    /* Процент побед */
    private RatingData winsRatio;
    /* Суммарный опыт */
    private RatingData xpAmount;
    /* Средний опыт за бой */
    private RatingData xpAvg;
    /* Максимальный опыт за бой */
    private RatingData xpMax;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBattlesToPlay() {
        return battlesToPlay;
    }

    public void setBattlesToPlay(int battlesToPlay) {
        this.battlesToPlay = battlesToPlay;
    }

    public RatingData getBattlesCount() {
        return battlesCount;
    }

    public void setBattlesCount(RatingData battlesCount) {
        this.battlesCount = battlesCount;
    }

    public RatingData getCapturePoints() {
        return capturePoints;
    }

    public void setCapturePoints(RatingData capturePoints) {
        this.capturePoints = capturePoints;
    }

    public RatingData getDamageAvg() {
        return damageAvg;
    }

    public void setDamageAvg(RatingData damageAvg) {
        this.damageAvg = damageAvg;
    }

    public RatingData getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(RatingData damageDealt) {
        this.damageDealt = damageDealt;
    }

    public RatingData getFragsAvg() {
        return fragsAvg;
    }

    public void setFragsAvg(RatingData fragsAvg) {
        this.fragsAvg = fragsAvg;
    }

    public RatingData getFragsCount() {
        return fragsCount;
    }

    public void setFragsCount(RatingData fragsCount) {
        this.fragsCount = fragsCount;
    }

    public RatingData getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(RatingData globalRating) {
        this.globalRating = globalRating;
    }

    public RatingData getHitsRatio() {
        return hitsRatio;
    }

    public void setHitsRatio(RatingData hitsRatio) {
        this.hitsRatio = hitsRatio;
    }

    public RatingData getSpottedAvg() {
        return spottedAvg;
    }

    public void setSpottedAvg(RatingData spottedAvg) {
        this.spottedAvg = spottedAvg;
    }

    public RatingData getSpottedCount() {
        return spottedCount;
    }

    public void setSpottedCount(RatingData spottedCount) {
        this.spottedCount = spottedCount;
    }

    public RatingData getSurvivedRatio() {
        return survivedRatio;
    }

    public void setSurvivedRatio(RatingData survivedRatio) {
        this.survivedRatio = survivedRatio;
    }

    public RatingData getWinsRatio() {
        return winsRatio;
    }

    public void setWinsRatio(RatingData winsRatio) {
        this.winsRatio = winsRatio;
    }

    public RatingData getXpAmount() {
        return xpAmount;
    }

    public void setXpAmount(RatingData xpAmount) {
        this.xpAmount = xpAmount;
    }

    public RatingData getXpAvg() {
        return xpAvg;
    }

    public void setXpAvg(RatingData xpAvg) {
        this.xpAvg = xpAvg;
    }

    public RatingData getXpMax() {
        return xpMax;
    }

    public void setXpMax(RatingData xpMax) {
        this.xpMax = xpMax;
    }

}
