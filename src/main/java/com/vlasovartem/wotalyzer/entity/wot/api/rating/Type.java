package com.vlasovartem.wotalyzer.entity.wot.api.rating;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 * Rating type
 */
public class Type {

    /* Категории рейтинга */
    private List<String> rankFields;
    /* Порог вхождения в рейтинг */
    private int threshold;
    /* Период формирования рейтинга */
    private String type;

    public List<String> getRankFields() {
        return rankFields;
    }

    public void setRankFields(List<String> rankFields) {
        this.rankFields = rankFields;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
