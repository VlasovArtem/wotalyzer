package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.ActiveBattle;

import java.util.List;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class Province {

    /* Map ID */
    private String arenaId;
    /* Localized map name */
    private String arenaName;
    /* List of IDs of attacking clans */
    private List<Integer> attackers;
    /* Battles start time in UTC */
    private String battlesStartAt;
    /* List of IDs of participating clans */
    private List<Integer> competitors;
    /* Current minimum bid */
    private int currentMinBet;
    /* Daily income */
    private int dailyRevenue;
    /* Front ID */
    private String frontId;
    /* Front name */
    private String frontName;
    /* Province borders are closed */
    private boolean isBordersDisabled;
    /* Landing type: auction, tournament or null */
    private String landingType;
    /* Last winning bid */
    private int lastWonBet;
    /* Maximum number of bids */
    private int maxBets;
    /* neighbours - List of adjacent provinces' IDs */
    private List<String> neighbours;
    /* Owning clan ID */
    private int ownerClanId;
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
    /* Round */
    private int roundNumber;
    /* Server ID */
    private String server;
    /* Tournament status: STARTED, FINISHED or null */
    private String status;
    /* Relative link to province */
    private String uri;
    /* Indicates if Repartition of the World is active */
    private boolean worldRedivision;
    /* active_battles - Current battles */
    private List<ActiveBattle> activeBattles;

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

    public List<Integer> getAttackers() {
        return attackers;
    }

    public void setAttackers(List<Integer> attackers) {
        this.attackers = attackers;
    }

    public String getBattlesStartAt() {
        return battlesStartAt;
    }

    public void setBattlesStartAt(String battlesStartAt) {
        this.battlesStartAt = battlesStartAt;
    }

    public List<Integer> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Integer> competitors) {
        this.competitors = competitors;
    }

    public int getCurrentMinBet() {
        return currentMinBet;
    }

    public void setCurrentMinBet(int currentMinBet) {
        this.currentMinBet = currentMinBet;
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

    public boolean isBordersDisabled() {
        return isBordersDisabled;
    }

    public void setBordersDisabled(boolean bordersDisabled) {
        isBordersDisabled = bordersDisabled;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public int getLastWonBet() {
        return lastWonBet;
    }

    public void setLastWonBet(int lastWonBet) {
        this.lastWonBet = lastWonBet;
    }

    public int getMaxBets() {
        return maxBets;
    }

    public void setMaxBets(int maxBets) {
        this.maxBets = maxBets;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }

    public int getOwnerClanId() {
        return ownerClanId;
    }

    public void setOwnerClanId(int ownerClanId) {
        this.ownerClanId = ownerClanId;
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

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean isWorldRedivision() {
        return worldRedivision;
    }

    public void setWorldRedivision(boolean worldRedivision) {
        this.worldRedivision = worldRedivision;
    }

    public List<ActiveBattle> getActiveBattles() {
        return activeBattles;
    }

    public void setActiveBattles(List<ActiveBattle> activeBattles) {
        this.activeBattles = activeBattles;
    }
}
