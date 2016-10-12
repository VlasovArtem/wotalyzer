package com.vlasovartem.wotalyzer.entity.wot.api.rating.components;

/**
 * Created by artemvlasov on 11/10/16.
 */
public class RatingData {

    /* Позиция */
    private int rank;
    /* Изменение позиции в рейтинге */
    private int rankDelta;
    /* Абсолютное значение */
    private Number value;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRankDelta() {
        return rankDelta;
    }

    public void setRankDelta(int rankDelta) {
        this.rankDelta = rankDelta;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
