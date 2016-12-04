package com.vlasovartem.wotalyzer.entity.wot.api.enums;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public enum RankField {

    BATTLES_COUNT("battles_count"), CAPTURE_POINTS("capture_points"), DAMAGE_AVG("damage_avg"), DAMAGE_DEALT("damage_dealt"), FRAGS_AVG("frags_avg"),
    FRAGS_COUNT("frags_count"), GLOBAL_RATING("global_rating"), HITS_RATIO("hits_ratio"), SPOTTED_AVG("spotted_avg"), SPOTTED_COUNT("spotted_count"),
    SURVIVED_RATIO("survived_ratio"), WINS_RATIO("wins_ratio"), XP_AMOUNT("xp_amount"), XP_AVG("xp_avg"), XP_MAX("xp_max");

    private String value;

    RankField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
