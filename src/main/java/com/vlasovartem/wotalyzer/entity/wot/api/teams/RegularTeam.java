package com.vlasovartem.wotalyzer.entity.wot.api.teams;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vlasovartem.wotalyzer.deserializers.EmblemDeserializer;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Emblem;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Ladder;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 * https://developers.wargaming.net/reference/all/wot/regularteams/list
 */
public class RegularTeam {

    /* Commander's account ID */
    private int captainId;
    /* Number of team members */
    private int membersCount;
    /* Team name */
    private String name;
    /* Team tag */
    private String tag;
    /* Team ID */
    private int teamId;
    /* Team emblems */
    @JsonDeserialize(using = EmblemDeserializer.class)
    private List<Emblem> emblems;
    /* Position in Ranked Battles */
    private Ladder ladder;

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
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
}
