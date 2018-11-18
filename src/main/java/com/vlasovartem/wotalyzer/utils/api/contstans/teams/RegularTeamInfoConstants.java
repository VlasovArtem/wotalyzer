package com.vlasovartem.wotalyzer.utils.api.contstans.teams;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TEAM_ID;

/**
 * Created by artemvlasov on 04/12/2016.
 */
public class RegularTeamInfoConstants extends BasicAPIConstants {

    private static RegularTeamInfoConstants constants;

    public static RegularTeamInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new RegularTeamInfoConstants();
        }
        return constants;
    }

    private RegularTeamInfoConstants() {
        super("https://api.worldoftanks.ru/wot/regularteams/info");
        List<String> data = Collections.singletonList(TEAM_ID);
        addBasicApiConstants(data);
        addRequiredParams(data);
    }

}
