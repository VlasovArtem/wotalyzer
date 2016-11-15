package com.vlasovartem.wotalyzer.entity.wn8.increase;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by artemvlasov on 11/11/2016.
 */
public class TankWN8IncreaseIndicator {

    private int tankId;
    private Set<WN8IncreaseIndicator> wn8IncreaseIndicators;

    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public Set<WN8IncreaseIndicator> getWn8IncreaseIndicators() {
        return wn8IncreaseIndicators;
    }

    public void setWn8IncreaseIndicators(Set<WN8IncreaseIndicator> wn8IncreaseIndicators) {
        this.wn8IncreaseIndicators = wn8IncreaseIndicators;
    }

    public void addWn8IncreaseIndicator(WN8IncreaseIndicator indicator) {
        if (Objects.nonNull(wn8IncreaseIndicators)) {
            wn8IncreaseIndicators.add(indicator);
        } else {
            wn8IncreaseIndicators = new HashSet<>();
            wn8IncreaseIndicators.add(indicator);
        }
    }
}
