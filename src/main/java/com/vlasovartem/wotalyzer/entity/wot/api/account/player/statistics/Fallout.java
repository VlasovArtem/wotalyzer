package com.vlasovartem.wotalyzer.entity.wot.api.account.player.statistics;

/**
 * Created by artemvlasov on 10/09/16.
 * Статистика в режиме «Бой до последнего»
 */
class Fallout extends MaxStatisticsData {

    /* Урон, нанесённый при помощи боевых резервов */
    private int avatarDamageDealt;
    /* Уничтожено при помощи боевых резервов */
    private int avatarFrags;
    /* Погиб */
    private int deathCount;
    /* Захвачено флагов в составе взвода */
    private int flagCapture;
    /* Захвачено флагов в роли одиночного игрока */
    private int flagCaptureSolo;
    /* Максимальный урон, нанесённый в одном бою, включая урон от аватара */
    private int maxDamageWithAvatar;
    /* Максимальное количество уничтоженной техники, включая технику, уничтоженную аватаром */
    private int maxFragsWithAvatar;
    /* Максимальное количество Очков победы, заработанное в режиме «Бой до последнего» */
    private int maxWinPoints;
    /* Ресурсы, захваченные на ресурсных точках */
    private int resourceAbsorbed;
    /* Очки победы */
    private int winPoints;

    public int getAvatarDamageDealt() {
        return avatarDamageDealt;
    }

    public void setAvatarDamageDealt(int avatarDamageDealt) {
        this.avatarDamageDealt = avatarDamageDealt;
    }

    public int getAvatarFrags() {
        return avatarFrags;
    }

    public void setAvatarFrags(int avatarFrags) {
        this.avatarFrags = avatarFrags;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getFlagCapture() {
        return flagCapture;
    }

    public void setFlagCapture(int flagCapture) {
        this.flagCapture = flagCapture;
    }

    public int getFlagCaptureSolo() {
        return flagCaptureSolo;
    }

    public void setFlagCaptureSolo(int flagCaptureSolo) {
        this.flagCaptureSolo = flagCaptureSolo;
    }

    public int getMaxDamageWithAvatar() {
        return maxDamageWithAvatar;
    }

    public void setMaxDamageWithAvatar(int maxDamageWithAvatar) {
        this.maxDamageWithAvatar = maxDamageWithAvatar;
    }

    public int getMaxFragsWithAvatar() {
        return maxFragsWithAvatar;
    }

    public void setMaxFragsWithAvatar(int maxFragsWithAvatar) {
        this.maxFragsWithAvatar = maxFragsWithAvatar;
    }

    public int getMaxWinPoints() {
        return maxWinPoints;
    }

    public void setMaxWinPoints(int maxWinPoints) {
        this.maxWinPoints = maxWinPoints;
    }

    public int getResourceAbsorbed() {
        return resourceAbsorbed;
    }

    public void setResourceAbsorbed(int resourceAbsorbed) {
        this.resourceAbsorbed = resourceAbsorbed;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(int winPoints) {
        this.winPoints = winPoints;
    }
}
