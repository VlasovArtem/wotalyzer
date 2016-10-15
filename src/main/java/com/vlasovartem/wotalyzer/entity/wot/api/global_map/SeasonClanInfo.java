package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.Season;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 * Method returns clan's statistics for a specific season.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonClanInfo {

    /* Clan info by seasons and vehicle Tiers */
    private List<Season> seasons;

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
