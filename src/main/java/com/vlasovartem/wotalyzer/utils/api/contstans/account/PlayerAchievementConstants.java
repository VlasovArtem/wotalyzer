package com.vlasovartem.wotalyzer.utils.api.contstans.account;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class PlayerAchievementConstants extends BasicAPIConstants {

    private static PlayerAchievementConstants constants;

    public static PlayerAchievementConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PlayerAchievementConstants();
        }
        return constants;
    }

    private PlayerAchievementConstants() {
        super("https://api.worldoftanks.ru/wot/account/achievements/");
        List<String> params = Collections.singletonList(ACCOUNT_ID_PARAM);
        addBasicApiConstants(params);
        addRequiredParams(params);
    }
}
