package com.vlasovartem.wotalyzer.entity.wot.api.teams;

/**
 * Created by artemvlasov on 14/10/2016.
 * https://developers.wargaming.net/reference/all/wot/regularteams/memberinfo
 */
public class MemberInfo {

    /* Account ID */
    private int accountId;
    /* Role */
    private String role;
    /* Team ID */
    private int teamId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
