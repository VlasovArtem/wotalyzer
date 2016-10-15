package com.vlasovartem.wotalyzer.entity.wot.api.global_map.components;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanRating {

    /* Clan Elo rating in Absolute division */
    private int elo10;
    /* Clan Elo rating in Medium division */
    private int elo6;
    /* Clan Elo rating in Champion division */
    private int elo8;
    /* Ratings update time */
    private LocalDateTime updatedAt;

    public int getElo10() {
        return elo10;
    }

    public void setElo10(int elo10) {
        this.elo10 = elo10;
    }

    public int getElo6() {
        return elo6;
    }

    public void setElo6(int elo6) {
        this.elo6 = elo6;
    }

    public int getElo8() {
        return elo8;
    }

    public void setElo8(int elo8) {
        this.elo8 = elo8;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
