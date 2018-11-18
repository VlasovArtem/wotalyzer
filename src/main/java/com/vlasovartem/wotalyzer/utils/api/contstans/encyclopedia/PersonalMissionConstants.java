package com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class PersonalMissionConstants extends BasicAPIConstants {

    private static PersonalMissionConstants constants;

    public static PersonalMissionConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new PersonalMissionConstants();
        }
        return constants;
    }

    private PersonalMissionConstants() {
        super("https://api.worldoftanks.ru/wot/encyclopedia/personalmissions");
        addBasicApiConstants(Arrays.asList(CAMPAIGN_ID_PARAM, OPERATION_ID_PARAM, SET_ID_PARAM, TAG_PARAM));
    }

}
