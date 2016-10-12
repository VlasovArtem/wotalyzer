package com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics;

/**
 * Created by artemvlasov on 10/09/16.
 */
class AverageStatisticsData extends BasicStatistics {

    /* Средний урон, нанесённый с вашей помощью. Значение считается с версии игры 8.9. */
    private float avgDamageAssisted;
    /* Средний урон по вашим разведданным. Значение считается с версии игры 8.9. */
    private float avgDamageAssistedRadio;
    /* Средний урон после вашего попадания, сбившего гусеницу. Значение считается с версии игры 8.9. */
    private float avgDamageAssistedTrack;
    /* Средний заблокированный бронёй урон за бой. Заблокированный бронёй урон — это урон от снарядов (бронебойных, кумулятивных и подкалиберных), которые попали в танк, но не нанесли урона. Значение считается с версии игры 9.0. */
    private float avgDamageBlocked;

    public float getAvgDamageAssisted() {
        return avgDamageAssisted;
    }

    public void setAvgDamageAssisted(float avgDamageAssisted) {
        this.avgDamageAssisted = avgDamageAssisted;
    }

    public float getAvgDamageAssistedRadio() {
        return avgDamageAssistedRadio;
    }

    public void setAvgDamageAssistedRadio(float avgDamageAssistedRadio) {
        this.avgDamageAssistedRadio = avgDamageAssistedRadio;
    }

    public float getAvgDamageAssistedTrack() {
        return avgDamageAssistedTrack;
    }

    public void setAvgDamageAssistedTrack(float avgDamageAssistedTrack) {
        this.avgDamageAssistedTrack = avgDamageAssistedTrack;
    }

    public float getAvgDamageBlocked() {
        return avgDamageBlocked;
    }

    public void setAvgDamageBlocked(float avgDamageBlocked) {
        this.avgDamageBlocked = avgDamageBlocked;
    }

}
