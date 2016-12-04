package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.util.Map;

/**
 * Created by artemvlasov on 15/10/2016.
 * Method returns clan's statistics for a specific season.
 * https://developers.wargaming.net/reference/all/wot/globalmap/seasonclaninfo/
 */
public class SeasonClanInfo {

    /* Clan info by seasons and vehicle Tiers */
    private Map<String, Season> seasons;

    public Map<String, Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Map<String, Season> seasons) {
        this.seasons = seasons;
    }
}
