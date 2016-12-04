package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.MapStatus;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 16/10/2016.
 * https://developers.wargaming.net/reference/all/wot/globalmap/info/
 */
public class Info {

    /* Number of last calculated turn */
    private int lastTurn;
    /* Calculation time of the last turn in UTC */
    private LocalDateTime lastTurnCalculatedAt;
    /* Creation time of the last calculated turn in UTC */
    private LocalDateTime lastTurnCreatedAt;
    /* WOTMap status: active, frozen, turn_calculation_in_progress */
    private MapStatus state;

    public int getLastTurn() {
        return lastTurn;
    }

    public void setLastTurn(int lastTurn) {
        this.lastTurn = lastTurn;
    }

    public LocalDateTime getLastTurnCalculatedAt() {
        return lastTurnCalculatedAt;
    }

    public void setLastTurnCalculatedAt(LocalDateTime lastTurnCalculatedAt) {
        this.lastTurnCalculatedAt = lastTurnCalculatedAt;
    }

    public LocalDateTime getLastTurnCreatedAt() {
        return lastTurnCreatedAt;
    }

    public void setLastTurnCreatedAt(LocalDateTime lastTurnCreatedAt) {
        this.lastTurnCreatedAt = lastTurnCreatedAt;
    }

    public MapStatus getState() {
        return state;
    }

    public void setState(MapStatus state) {
        this.state = state;
    }
}
