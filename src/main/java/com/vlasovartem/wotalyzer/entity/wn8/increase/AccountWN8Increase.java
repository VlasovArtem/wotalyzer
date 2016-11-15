package com.vlasovartem.wotalyzer.entity.wn8.increase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by artemvlasov on 11/11/2016.
 */
public class AccountWN8Increase {

    private int accountId;
    private List<TankWN8IncreaseIndicator> tankWN8IncreaseIndicators;

    public AccountWN8Increase(int accountId, List<TankWN8IncreaseIndicator> tankWN8IncreaseIndicators) {
        this.accountId = accountId;
        this.tankWN8IncreaseIndicators = tankWN8IncreaseIndicators;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<TankWN8IncreaseIndicator> getTankWN8IncreaseIndicators() {
        return tankWN8IncreaseIndicators;
    }

    public void setTankWN8IncreaseIndicators(List<TankWN8IncreaseIndicator> tankWN8IncreaseIndicators) {
        this.tankWN8IncreaseIndicators = tankWN8IncreaseIndicators;
    }

    public void addTankWN8IncreaseIndicator(TankWN8IncreaseIndicator indicator) {
        if (Objects.nonNull(tankWN8IncreaseIndicators)) {
            tankWN8IncreaseIndicators.add(indicator);
        } else {
            tankWN8IncreaseIndicators = new ArrayList<>();
            tankWN8IncreaseIndicators.add(indicator);
        }
    }
}
