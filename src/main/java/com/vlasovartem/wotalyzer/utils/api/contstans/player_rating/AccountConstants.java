package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class AccountConstants extends BasicAPIConstants {

    private static AccountConstants constants;

    public static AccountConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new AccountConstants();
        }
        return constants;
    }

    private AccountConstants() {
        super("https://api.worldoftanks.ru/wot/ratings/accounts/");
        addBasicApiConstants(Arrays.asList(TYPE_PARAM, ACCOUNT_ID_PARAM, BATTLE_TYPE_PARAM, DATE_PARAM));
        addRequiredParams(Arrays.asList(TYPE_PARAM, ACCOUNT_ID_PARAM));
    }

}
