package com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics;

/**
 * Created by artemvlasov on 10/09/16.
 */
class BasicStatistics {

    /* Средний опыт за бой */
    private int battleAvgXp;
    /* Проведено боёв */
    private int battles;
    /* Очки захвата базы */
    private int capturePoints;
    /* Нанесено повреждений */
    private int damageDealt;
    /* Получено урона */
    private int damageReceived;
    /* Количество полученных прямых попаданий */
    private int directHitsReceived;
    /* Ничьи */
    private int draws;
    /* Очки защиты базы */
    private int droppedCapturePoints;
    /* Количество нанесённых осколочно-фугасных попаданий */
    private int explosionHits;
    /* Количество полученных осколочно-фугасных попаданий */
    private int explosionHitsReceived;
    /* Уничтожено техники */
    private int frags;
    /* Попадания */
    private int hits;
    /* Процент попаданий */
    private int hitsPercents;
    /* Поражения */
    private int losses;
    /* Количество полученных прямых попаданий, не нанёсших урон */
    private int noDamageDirectHitsReceived;
    /* Количество пробитий */
    private int piercings;
    /* Количество полученных пробитий */
    private int piercingsReceived;
    /* Произведено выстрелов */
    private int shots;
    /* Обнаружено противников */
    private int spotted;
    /* Выжил в боях */
    private int survivedBattles;
    /* Отношение заблокированного бронёй урона к полученному игроком урону от бронебойных, кумулятивных, подкалиберных снарядов. Значение считается с версии игры 9.0. */
    private float tankingFactor;
    /* Победы */
    private int wins;
    /* Суммарный опыт */
    private long xp;

    public int getBattleAvgXp() {
        return battleAvgXp;
    }

    public void setBattleAvgXp(int battleAvgXp) {
        this.battleAvgXp = battleAvgXp;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getCapturePoints() {
        return capturePoints;
    }

    public void setCapturePoints(int capturePoints) {
        this.capturePoints = capturePoints;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(int damageReceived) {
        this.damageReceived = damageReceived;
    }

    public int getDirectHitsReceived() {
        return directHitsReceived;
    }

    public void setDirectHitsReceived(int directHitsReceived) {
        this.directHitsReceived = directHitsReceived;
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

    public int getExplosionHits() {
        return explosionHits;
    }

    public void setExplosionHits(int explosionHits) {
        this.explosionHits = explosionHits;
    }

    public int getExplosionHitsReceived() {
        return explosionHitsReceived;
    }

    public void setExplosionHitsReceived(int explosionHitsReceived) {
        this.explosionHitsReceived = explosionHitsReceived;
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

    public int getNoDamageDirectHitsReceived() {
        return noDamageDirectHitsReceived;
    }

    public void setNoDamageDirectHitsReceived(int noDamageDirectHitsReceived) {
        this.noDamageDirectHitsReceived = noDamageDirectHitsReceived;
    }

    public int getPiercings() {
        return piercings;
    }

    public void setPiercings(int piercings) {
        this.piercings = piercings;
    }

    public int getPiercingsReceived() {
        return piercingsReceived;
    }

    public void setPiercingsReceived(int piercingsReceived) {
        this.piercingsReceived = piercingsReceived;
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

    public float getTankingFactor() {
        return tankingFactor;
    }

    public void setTankingFactor(float tankingFactor) {
        this.tankingFactor = tankingFactor;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }
}
