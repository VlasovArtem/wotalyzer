package com.vlasovartem.wotalyzer.service.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.ExpectedData;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 03/11/2016.
 */
public interface ExpectedDataService {

    ExpectedData getAccountExpectedData (long accountId);
    Optional<ExpectedData> getAccountExpectedDataByTankId(int accountId, int tankId);
    ExpectedData getAccountExpectedDataByTankIds(int accountId, List<Integer> tankIds);
    ExpectedData getAccountExpectedDataByTier(int account, int tier);
    ExpectedData getAccountExpectedDataByTierBetween(int account, int minTier, int maxTier);

}
