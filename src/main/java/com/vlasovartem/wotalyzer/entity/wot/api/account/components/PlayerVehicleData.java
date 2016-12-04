package com.vlasovartem.wotalyzer.entity.wot.api.account.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;

/**
 * Created by artemvlasov on 10/09/16.
 */
public class PlayerVehicleData extends MainEntity {

    private int markOfMastery;
    private Statistics statistics;

    private class Statistics {
        private int battles;
        private int wins;

        public int getBattles() {
            return battles;
        }

        public void setBattles(int battles) {
            this.battles = battles;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }
    }

    @Override
    @JsonProperty("tank_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public int getMarkOfMastery() {
        return markOfMastery;
    }

    public void setMarkOfMastery(int markOfMastery) {
        this.markOfMastery = markOfMastery;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}
