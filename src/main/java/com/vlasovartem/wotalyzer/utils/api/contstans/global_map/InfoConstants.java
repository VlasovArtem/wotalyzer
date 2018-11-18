package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class InfoConstants extends BasicAPIConstants {

    private static InfoConstants constants;

    public static InfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new InfoConstants();
        }
        return constants;
    }

    private InfoConstants() {
        super("https://api.worldoftanks.ru/wot/globalmap/info");
    }

}
