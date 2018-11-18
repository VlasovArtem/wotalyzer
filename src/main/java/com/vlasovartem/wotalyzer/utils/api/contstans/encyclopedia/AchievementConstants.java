package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class AchievementConstants extends BasicAPIConstants {

    private static AchievementConstants constants;

    public static AchievementConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new AchievementConstants();
        }
        return constants;
    }

    private AchievementConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/achievements/");
    }

}
