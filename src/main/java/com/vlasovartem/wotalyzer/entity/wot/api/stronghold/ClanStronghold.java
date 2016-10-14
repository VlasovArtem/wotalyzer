package com.vlasovartem.wotalyzer.entity.wot.api.stronghold;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components.Building;
import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components.Defense;
import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components.Private;
import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components.Skirmish;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class ClanStronghold {

    /* Total number of battles fought by clan */
    private int battlesCountTotal;
    /* Number of structures */
    private int buildingsCount;
    /* Clan ID */
    private int clanId;
    /* Clan name */
    private String clanName;
    /* Clan Tag */
    private String clanTag;
    /* Ceasefire day. Indicates the index number of the weekday: 0 - Monday, ..., 6 - Sunday. If the Defense Period is not activated, value is -1. */
    private int dayOff;
    /* Indicates if the defense period is activated */
    private boolean defenseModeIsActivated;
    /* Names of Zones available in Stronghold */
    private List<String> directions;
    /* Number of Zones */
    private int directionsCount;
    /* Tier */
    private int level;
    /* Server ID Use server field */
    private int peripheryId;
    /* Server ID */
    private String server;
    /* End date of Period of Neutrality */
    private LocalDateTime vacationFinish;
    /* Start date of Period of Neutrality */
    private LocalDateTime vacationStart;
    /* Structures info by unique type IDs */
    private List<Building> buildings;
    /* Information on the active Defense Period. If defense is deactivated, field value is null. */
    private Defense defense;
    /* Restricted Stronghold data */
    @JsonProperty("private")
    private Private aPrivate;
    /* skirmish - Information on Skirmishes */
    private Skirmish skirmish;

    public int getBattlesCountTotal() {
        return battlesCountTotal;
    }

    public void setBattlesCountTotal(int battlesCountTotal) {
        this.battlesCountTotal = battlesCountTotal;
    }

    public int getBuildingsCount() {
        return buildingsCount;
    }

    public void setBuildingsCount(int buildingsCount) {
        this.buildingsCount = buildingsCount;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public String getClanTag() {
        return clanTag;
    }

    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public boolean isDefenseModeIsActivated() {
        return defenseModeIsActivated;
    }

    public void setDefenseModeIsActivated(boolean defenseModeIsActivated) {
        this.defenseModeIsActivated = defenseModeIsActivated;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public int getDirectionsCount() {
        return directionsCount;
    }

    public void setDirectionsCount(int directionsCount) {
        this.directionsCount = directionsCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPeripheryId() {
        return peripheryId;
    }

    public void setPeripheryId(int peripheryId) {
        this.peripheryId = peripheryId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public LocalDateTime getVacationFinish() {
        return vacationFinish;
    }

    public void setVacationFinish(LocalDateTime vacationFinish) {
        this.vacationFinish = vacationFinish;
    }

    public LocalDateTime getVacationStart() {
        return vacationStart;
    }

    public void setVacationStart(LocalDateTime vacationStart) {
        this.vacationStart = vacationStart;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public Private getaPrivate() {
        return aPrivate;
    }

    public void setaPrivate(Private aPrivate) {
        this.aPrivate = aPrivate;
    }

    public Skirmish getSkirmish() {
        return skirmish;
    }

    public void setSkirmish(Skirmish skirmish) {
        this.skirmish = skirmish;
    }
}
