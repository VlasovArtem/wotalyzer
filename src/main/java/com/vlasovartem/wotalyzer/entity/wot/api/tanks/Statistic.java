package com.vlasovartem.wotalyzer.entity.wot.api.tanks;

import com.vlasovartem.wotalyzer.entity.wot.api.tanks.components.*;

import java.util.Map;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class Statistic {

    /* Player account ID */
    private int accountId;
    /* Mastery Badges: 0 — None 1 — 3rd Class 2 — 2nd Class 3 — 1st Class 4 — Ace Tanker */
    private int markOfMastery;
    /* Maximum destroyed in battle */
    private int maxFrags;
    /* Maximum experience per battle */
    private int maxXp;
    /* Vehicle ID */
    private int tankId;
    /* Details on vehicles destroyed. This data requires a valid access_token for the specified account. */
    private Map<String, String> frags;
    /* Availability of vehicle in the Garage. This data requires a valid access_token for the specified account. */
    private boolean inGarage;
    /* Overall Statistics */
    private OverallStatistic all;
    /* Clan battles statistics */
    private ClanStatistic clan;
    /* Tank Company battles statistics */
    private MainStatistic company;
    /* Fallout statistics. An extra field. */
    private FalloutStatistic fallout;
    /* All battle statistics on the Global Map */
    private GlobalmapStatistic globalmap;
    /* Random battles statistics. An extra field. */
    private ClanStatistic random;
    /* Battle statistics of permanent teams */
    private ClanStatistic regularTeam;
    /* General stats for player's battles in Stronghold defense */
    private StrongholdStatistic strongholdDefense;
    /* General stats for player's battles in Skirmishes */
    private StrongholdStatistic strongholdSkirmish;
    /* Team battles statistics */
    private ClanStatistic team;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getMarkOfMastery() {
        return markOfMastery;
    }

    public void setMarkOfMastery(int markOfMastery) {
        this.markOfMastery = markOfMastery;
    }

    public int getMaxFrags() {
        return maxFrags;
    }

    public void setMaxFrags(int maxFrags) {
        this.maxFrags = maxFrags;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public Map<String, String> getFrags() {
        return frags;
    }

    public void setFrags(Map<String, String> frags) {
        this.frags = frags;
    }

    public boolean isInGarage() {
        return inGarage;
    }

    public void setInGarage(boolean inGarage) {
        this.inGarage = inGarage;
    }

    public OverallStatistic getAll() {
        return all;
    }

    public void setAll(OverallStatistic all) {
        this.all = all;
    }

    public ClanStatistic getClan() {
        return clan;
    }

    public void setClan(ClanStatistic clan) {
        this.clan = clan;
    }

    public MainStatistic getCompany() {
        return company;
    }

    public void setCompany(MainStatistic company) {
        this.company = company;
    }

    public FalloutStatistic getFallout() {
        return fallout;
    }

    public void setFallout(FalloutStatistic fallout) {
        this.fallout = fallout;
    }

    public GlobalmapStatistic getGlobalmap() {
        return globalmap;
    }

    public void setGlobalmap(GlobalmapStatistic globalmap) {
        this.globalmap = globalmap;
    }

    public ClanStatistic getRandom() {
        return random;
    }

    public void setRandom(ClanStatistic random) {
        this.random = random;
    }

    public ClanStatistic getRegularTeam() {
        return regularTeam;
    }

    public void setRegularTeam(ClanStatistic regularTeam) {
        this.regularTeam = regularTeam;
    }

    public StrongholdStatistic getStrongholdDefense() {
        return strongholdDefense;
    }

    public void setStrongholdDefense(StrongholdStatistic strongholdDefense) {
        this.strongholdDefense = strongholdDefense;
    }

    public StrongholdStatistic getStrongholdSkirmish() {
        return strongholdSkirmish;
    }

    public void setStrongholdSkirmish(StrongholdStatistic strongholdSkirmish) {
        this.strongholdSkirmish = strongholdSkirmish;
    }

    public ClanStatistic getTeam() {
        return team;
    }

    public void setTeam(ClanStatistic team) {
        this.team = team;
    }
}
