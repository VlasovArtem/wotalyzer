package com.vlasovartem.wotalyzer.entity.wot.api.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Emblem;
import com.vlasovartem.wotalyzer.entity.wot.api.teams.components.Ladder;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class RegularTeamsList {

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
    private List<Emblem> emblems;
    /* Position in Ranked Battles */
    private Ladder ladder;

}
