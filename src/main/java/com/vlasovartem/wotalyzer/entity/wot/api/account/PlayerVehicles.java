package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by artemvlasov on 10/09/16.
 */
@JsonAutoDetect
public class PlayerVehicles {

    private int markOfMastery;
    private int tankId;
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
