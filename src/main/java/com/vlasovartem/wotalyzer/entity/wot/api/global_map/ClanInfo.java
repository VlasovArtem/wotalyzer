package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.ClanRating;
import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.ClanStatistic;

/**
 * Created by artemvlasov on 15/10/2016.
 * https://developers.wargaming.net/reference/all/wot/globalmap/claninfo/
 */
public class ClanInfo {

    /* Clan ID */
    private int clanId;
    /* Clan name */
    private String name;
    /* Clan Tag */
    private String tag;
    /* Restricted clan information on the Global WOTMap */
    @JsonProperty("private")
    private Private aPrivate;
    /* Clan rating on the Global WOTMap */
    private ClanRating ratings;
    /* Clan statistics on the Global WOTMap */
    private ClanStatistic statistics;

    
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

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Private getaPrivate() {
        return aPrivate;
    }

    public void setaPrivate(Private aPrivate) {
        this.aPrivate = aPrivate;
    }

    public ClanRating getRatings() {
        return ratings;
    }

    public void setRatings(ClanRating ratings) {
        this.ratings = ratings;
    }

    public ClanStatistic getStatistics() {
        return statistics;
    }

    public void setStatistics(ClanStatistic statistics) {
        this.statistics = statistics;
    }
}
