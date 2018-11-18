package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.AccountStats;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.AccountStatsConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountStatsUtils extends MainUtils<AccountStats> {

    @Override
    protected Class<AccountStats> getType() {
        return AccountStats.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return AccountStatsConstants.getInstance();
    }
}
