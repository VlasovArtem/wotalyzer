package com.vlasovartem.wotalyzer.utils.uri.wot.api.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.AccountStats;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.AccountStatsConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountStatsUtils extends MainUtils<AccountStats> {

    @Override
    protected Class getType() {
        return AccountStats.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return AccountStatsConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return AccountStatsConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return AccountStatsConstants.REQUIRED_PARAMS;
    }
}
