package com.vlasovartem.wotalyzer.service.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.increase.AccountWN8Increase;

/**
 * Created by artemvlasov on 11/11/2016.
 */
public interface AccountWN8IncreaseService {

    AccountWN8Increase getAccountWN8IncreaseData(int accountId, int tankTier);
    AccountWN8Increase getAccountWN8IncreaseData(int accountId, int minTankTier, int maxTankTier);

}
