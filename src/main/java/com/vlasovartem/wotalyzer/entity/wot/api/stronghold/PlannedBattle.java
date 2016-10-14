package com.vlasovartem.wotalyzer.entity.wot.api.stronghold;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlannedBattle {

    /* Attack direction */
    private String attackDirection;
    /* Attacking clan ID */
    private int attackerClanId;
    /* Attacking clan name */
    private String attackerClanName;
    /* Attacking clan tag */
    private String attackerClanTag;
    /* Battle creation date */
    private LocalDateTime battleCreationDate;
    /* Battle planned date */
    private LocalDateTime battlePlannedDate;
    /* Battle type (attack / defense) */
    private String battleType;
    /* Defending clan ID */
    private int defenderClanId;
    /* Defending clan name */
    private String defenderClanName;
    /* Defending clan tag */
    private String defenderClanTag;
    /* Defense direction */
    private String defenseDirection;

    public String getAttackDirection() {
        return attackDirection;
    }

    public void setAttackDirection(String attackDirection) {
        this.attackDirection = attackDirection;
    }

    public int getAttackerClanId() {
        return attackerClanId;
    }

    public void setAttackerClanId(int attackerClanId) {
        this.attackerClanId = attackerClanId;
    }

    public String getAttackerClanName() {
        return attackerClanName;
    }

    public void setAttackerClanName(String attackerClanName) {
        this.attackerClanName = attackerClanName;
    }

    public String getAttackerClanTag() {
        return attackerClanTag;
    }

    public void setAttackerClanTag(String attackerClanTag) {
        this.attackerClanTag = attackerClanTag;
    }

    public LocalDateTime getBattleCreationDate() {
        return battleCreationDate;
    }

    public void setBattleCreationDate(LocalDateTime battleCreationDate) {
        this.battleCreationDate = battleCreationDate;
    }

    public LocalDateTime getBattlePlannedDate() {
        return battlePlannedDate;
    }

    public void setBattlePlannedDate(LocalDateTime battlePlannedDate) {
        this.battlePlannedDate = battlePlannedDate;
    }

    public String getBattleType() {
        return battleType;
    }

    public void setBattleType(String battleType) {
        this.battleType = battleType;
    }

    public int getDefenderClanId() {
        return defenderClanId;
    }

    public void setDefenderClanId(int defenderClanId) {
        this.defenderClanId = defenderClanId;
    }

    public String getDefenderClanName() {
        return defenderClanName;
    }

    public void setDefenderClanName(String defenderClanName) {
        this.defenderClanName = defenderClanName;
    }

    public String getDefenderClanTag() {
        return defenderClanTag;
    }

    public void setDefenderClanTag(String defenderClanTag) {
        this.defenderClanTag = defenderClanTag;
    }

    public String getDefenseDirection() {
        return defenseDirection;
    }

    public void setDefenseDirection(String defenseDirection) {
        this.defenseDirection = defenseDirection;
    }
}
