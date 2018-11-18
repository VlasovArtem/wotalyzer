package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Objects;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class PersonalReserveConstants extends BasicAPIConstants {

    private static PersonalReserveConstants constants;

    public static PersonalReserveConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PersonalReserveConstants();
        }
        return constants;
    }

    private PersonalReserveConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/boosters");
    }

}
