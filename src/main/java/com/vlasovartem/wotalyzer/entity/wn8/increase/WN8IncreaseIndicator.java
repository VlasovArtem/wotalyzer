package com.vlasovartem.wotalyzer.entity.wn8.increase;

import java.util.Objects;

/**
 * Created by artemvlasov on 11/11/2016.
 */
public class WN8IncreaseIndicator {

    private IndicatorType indicatorType;
    private IndicatorImpact indicatorImpact;

    public WN8IncreaseIndicator(IndicatorType indicatorType, IndicatorImpact indicatorImpact) {
        if (Objects.nonNull(indicatorImpact) && Objects.nonNull(indicatorType)) {
            this.indicatorType = indicatorType;
            this.indicatorImpact = indicatorImpact;
        }
    }

    public IndicatorType getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.indicatorType = indicatorType;
    }

    public IndicatorImpact getIndicatorImpact() {
        return indicatorImpact;
    }

    public void setIndicatorImpact(IndicatorImpact indicatorImpact) {
        this.indicatorImpact = indicatorImpact;
    }

    public enum IndicatorType {
        DAMAGE, FRAGS, SPOTTED, DEFENCE, WIN_RATE
    }

    public enum IndicatorImpact {
        NONE, HIGH, MEDIUM, LOW
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WN8IncreaseIndicator)) return false;

        WN8IncreaseIndicator that = (WN8IncreaseIndicator) o;


        if (indicatorType != that.indicatorType) return false;
        return indicatorImpact == that.indicatorImpact;
    }

    @Override
    public int hashCode() {
        int result = indicatorType.hashCode();
        result = 31 * result + indicatorImpact.hashCode();
        return result;
    }
}
