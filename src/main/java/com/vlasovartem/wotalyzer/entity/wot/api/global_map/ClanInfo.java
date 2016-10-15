package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.ClanRating;
import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.ClanStatistic;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanInfo {

    /* Clan ID */
    private int clanId;
    /* Clan name */
    private String name;
    /* Clan Tag */
    private String tag;
    /* Restricted clan information on the Global Map */
    @JsonProperty("private")
    private Private aPrivate;
    /* Clan rating on the Global Map */
    private List<ClanRating> ratings;
    /* Clan statistics on the Global Map */
    private List<ClanStatistic> statistics;

    
    private class Private {
        /* Influence points spent per day */
        private int dailyWage;
        /* Influence points */
        private int influence;

        public int getDailyWage() {
            return dailyWage;
        }

        public void setDailyWage(int dailyWage) {
            this.dailyWage = dailyWage;
        }

        public int getInfluence() {
            return influence;
        }

        public void setInfluence(int influence) {
            this.influence = influence;
        }
    }
    
}
