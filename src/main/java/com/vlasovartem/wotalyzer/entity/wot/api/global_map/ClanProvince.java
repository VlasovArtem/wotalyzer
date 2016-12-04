package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by artemvlasov on 15/10/2016.
 * https://developers.wargaming.net/reference/all/wot/globalmap/clanprovinces/
 */
public class ClanProvince {

    /* WOTMap ID */
    private String arenaId;
    /* Localized map name */
    private String arenaName;
    /* Clan ID */
    private int clanId;
    /* Daily income */
    private int dailyRevenue;
    /* Front ID */
    private String frontId;
    /* Front name */
    private String frontName;
    /* Indicates the landing type of a province */
    private String landingType;
    /* Maximum vehicle Tier in a Front */
    private int maxVehicleLevel;
    /* Date when province will restore its revenue after ransack */
    private String pillageEndAt;
    /* Prime Time in UTC */
    private String primeTime;
    /* Province ID */
    private String provinceId;
    /* Province name */
    private String provinceName;
    /* Income level from 0 to 11. 0 value means that income was not raised. */
    private int revenueLevel;
    /* Province owned (number of turns) */
    private int turnsOwned;
    /* Indicates the landing type of a provinceWarning. The field will be disabled. */
    private boolean landing;
    /* private - Restricted province information */
    @JsonProperty("private")
    private Private aPrivate;


    private class Private {
        /* Indicates availability of connection to the Headquarters */
        private boolean hqConnected;

        public boolean isHqConnected() {
            return hqConnected;
        }

        public void setHqConnected(boolean hqConnected) {
            this.hqConnected = hqConnected;
        }
    }

    public String getArenaId() {
        return arenaId;
    }

    public void setArenaId(String arenaId) {
        this.arenaId = arenaId;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public int getDailyRevenue() {
        return dailyRevenue;
    }

    public void setDailyRevenue(int dailyRevenue) {
        this.dailyRevenue = dailyRevenue;
    }

    public String getFrontId() {
        return frontId;
    }

    public void setFrontId(String frontId) {
        this.frontId = frontId;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public int getMaxVehicleLevel() {
        return maxVehicleLevel;
    }

    public void setMaxVehicleLevel(int maxVehicleLevel) {
        this.maxVehicleLevel = maxVehicleLevel;
    }

    public String getPillageEndAt() {
        return pillageEndAt;
    }

    public void setPillageEndAt(String pillageEndAt) {
        this.pillageEndAt = pillageEndAt;
    }

    public String getPrimeTime() {
        return primeTime;
    }

    public void setPrimeTime(String primeTime) {
        this.primeTime = primeTime;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getRevenueLevel() {
        return revenueLevel;
    }

    public void setRevenueLevel(int revenueLevel) {
        this.revenueLevel = revenueLevel;
    }

    public int getTurnsOwned() {
        return turnsOwned;
    }

    public void setTurnsOwned(int turnsOwned) {
        this.turnsOwned = turnsOwned;
    }

    public boolean isLanding() {
        return landing;
    }

    public void setLanding(boolean landing) {
        this.landing = landing;
    }

    public Private getaPrivate() {
        return aPrivate;
    }

    public void setaPrivate(Private aPrivate) {
        this.aPrivate = aPrivate;
    }
}
