package com.vlasovartem.wotalyzer.utils.api.contstans.stronghold;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class StructureConstants extends BasicAPIConstants {

    private static StructureConstants constants;

    public static StructureConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new StructureConstants();
        }
        return constants;
    }

    private StructureConstants() {
        super("https://api.worldoftanks.ru/wot/stronghold/buildings");
    }

}
