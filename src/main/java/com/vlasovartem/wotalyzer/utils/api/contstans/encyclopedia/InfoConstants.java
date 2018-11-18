package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 09/10/16.
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
        super("https://api.worldoftanks.ru/wot/encyclopedia/info/");
    }
    

}
