package com.vlasovartem.wotalyzer.entity.wot.api.teams;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vlasovartem.wotalyzer.deserializers.EmblemDeserializer;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Emblem;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Ladder;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Player;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 * https://developers.wargaming.net/reference/all/wot/regularteams/info
 */
public class RegularTeamInfo {

    /* Team can invite players */
    private boolean acceptsJoinRequests;
    /* Team can participate in Random Battles */
    private boolean allowRandomBattles;
    /* Number of battles played by a team */
    private int battlesCount;
    /* Commander's account ID */
    private int captainId;
    /* Team creation date */
    private LocalDateTime createdAt;
    /* Team description */
    private String description;
    /* Number of team members */
    private int membersCount;
    /* Team name */
    private String name;
    /* Short team description */
    private String shortDescription;
    /* Team tag */
    private String tag;
    /* Team ID */
    private int teamId;
    /* Date when team data were updated */
    private LocalDateTime updatedAt;
    /* Number of victories of a team */
    private int winsCount;
    /* Team emblems */
    @JsonDeserialize(using = EmblemDeserializer.class)
    private List<Emblem> emblems;
    /* Position in Ranked Battles */
    private Ladder ladder;
    /* List of team members */
    private List<Player> players;

    public boolean isAcceptsJoinRequests() {
        return acceptsJoinRequests;
    }

    public void setAcceptsJoinRequests(boolean acceptsJoinRequests) {
        this.acceptsJoinRequests = acceptsJoinRequests;
    }

    public boolean isAllowRandomBattles() {
        return allowRandomBattles;
    }

    public void setAllowRandomBattles(boolean allowRandomBattles) {
        this.allowRandomBattles = allowRandomBattles;
    }

    public int getBattlesCount() {
        return battlesCount;
    }

    public void setBattlesCount(int battlesCount) {
        this.battlesCount = battlesCount;
    }

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }

    public List<Emblem> getEmblems() {
        return emblems;
    }

    public void setEmblems(List<Emblem> emblems) {
        this.emblems = emblems;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
