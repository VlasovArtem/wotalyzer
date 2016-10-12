package com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics;

/**
 * Created by artemvlasov on 10/09/16.
 */
class MaxStatisticsData extends AverageStatisticsData {

    /* Максимальный урон за бой */
    private int maxDamage;
    /* Техника, на которой был нанесён максимальный урон за бой */
    private int maxDamageTankId;
    /* Максимум уничтожено за бой */
    private int maxFrags;
    /* Техника, на которой уничтожено максимальное количество противников за бой */
    private int maxFragsTankId;
    /* Максимальный опыт за бой */
    private int maxXp;
    /* Техника, на которой получен максимальный опыт за бой */
    private int maxXpTankId;

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamageTankId() {
        return maxDamageTankId;
    }

    public void setMaxDamageTankId(int maxDamageTankId) {
        this.maxDamageTankId = maxDamageTankId;
    }

    public int getMaxFrags() {
        return maxFrags;
    }

    public void setMaxFrags(int maxFrags) {
        this.maxFrags = maxFrags;
    }

    public int getMaxFragsTankId() {
        return maxFragsTankId;
    }

    public void setMaxFragsTankId(int maxFragsTankId) {
        this.maxFragsTankId = maxFragsTankId;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    public int getMaxXpTankId() {
        return maxXpTankId;
    }

    public void setMaxXpTankId(int maxXpTankId) {
        this.maxXpTankId = maxXpTankId;
    }
}
