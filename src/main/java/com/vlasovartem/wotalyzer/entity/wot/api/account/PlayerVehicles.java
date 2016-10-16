package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;

/**
 * Created by artemvlasov on 10/09/16.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerVehicles extends MainEntity{

    @JsonProperty("tank_id")
    private int id;
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

}
