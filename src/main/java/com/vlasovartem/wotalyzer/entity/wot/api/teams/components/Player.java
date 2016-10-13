package com.vlasovartem.wotalyzer.entity.wot.api.teams.components;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class Player {

    /* Player account ID */
    private int accountId;
    /* Date when joined the team */
    private LocalDateTime joinedAt;
    /* Technical position name in a team */
    private String role;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
