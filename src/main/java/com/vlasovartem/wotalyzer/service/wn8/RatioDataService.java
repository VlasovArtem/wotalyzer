package com.vlasovartem.wotalyzer.service.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.RationData;

/**
 * Created by artemvlasov on 03/11/2016.
 */
public interface RatioDataService {

    RationData getAccountRatioData(long accountId);
    RationData getAccountRatioDataZeroPoint(long accountId);

}
