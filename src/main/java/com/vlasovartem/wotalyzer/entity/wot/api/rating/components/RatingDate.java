package com.vlasovartem.wotalyzer.entity.wot.api.rating.components;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 * Dates with available ratings
 */
public abstract class RatingDate {

    private List<LocalDateTime> dates;

    public List<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(List<LocalDateTime> dates) {
        this.dates = dates;
    }
}
