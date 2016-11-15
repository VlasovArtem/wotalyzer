package com.vlasovartem.wotalyzer.service.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.RatioData;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 03/11/2016.
 */
public interface RatioDataService {

    RatioData getAccountRatioData(int accountId);
    RatioData getAccountRatioDataZeroPoint(int accountId);
    Optional<RatioData> getAccountRatioDataByTankId(int accountId, int tankId);
    RatioData getAccountRatioDataByTankIds(int accountId, List<Integer> tankIds);
    RatioData getAccountRatioDataByTier(int account, int tier);
    RatioData getAccountRatioDataByTierBetween(int account, int minTier, int maxTier);

}
