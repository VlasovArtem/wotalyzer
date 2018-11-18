package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 09/10/16.
 */
public class WOTMapConstants extends BasicAPIConstants {

    private static WOTMapConstants constants;

    public static WOTMapConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new WOTMapConstants();
        }
        return constants;
    }

    private WOTMapConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/arenas/");
    }

}
