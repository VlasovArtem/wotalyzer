package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public enum ClanRankField {

    BATTLES_COUNT_AVG("battles_count_avg"), BATTLES_COUNT_AVG_DAILY("battles_count_avg_daily"), EFFICIENCY("efficiency"), FB_ELO_RATING("fb_elo_rating"),
    FB_ELO_RATING_10("fb_elo_rating_10"), FB_ELO_RATING_8("fb_elo_rating_8"), GLOBAL_RATING_AVG("global_rating_avg"), GLOBAL_RATING_WEIGHTED_AVG("global_rating_weighted_avg"),
    GM_ELO_RATING("gm_elo_rating"), GM_ELO_RATING_10("gm_elo_rating_10"), GM_ELO_RATING_8("gm_elo_rating_8"), GM_ELO_RATING_6("gm_elo_rating_6"),
    V10L_AVG("v10l_avg"), WINS_RATIO_AVG("wins_ratio_avg");

    private String value;

    ClanRankField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
