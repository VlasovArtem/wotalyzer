package com.vlasovartem.wotalyzer.utils.api.contstans.stronghold;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCESS_TOKEN_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountStatsConstants extends BasicAPIConstants {

    private static AccountStatsConstants constants;

    public static AccountStatsConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new AccountStatsConstants();
        }
        return constants;
    }

    private AccountStatsConstants() {
        super("https://api.worldoftanks.ru/wot/stronghold/accountstats");
        addBasicApiConstants(Arrays.asList(ACCOUNT_ID_PARAM, ACCESS_TOKEN_PARAM));
        addRequiredParams(Collections.singletonList(ACCOUNT_ID_PARAM));
    }

}
