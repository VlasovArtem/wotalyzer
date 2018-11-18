package com.vlasovartem.wotalyzer.utils.api.contstans.teams;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.ACCOUNT_ID_PARAM;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class MemberInfoConstants extends BasicAPIConstants {

    private static MemberInfoConstants constants;

    public static MemberInfoConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new MemberInfoConstants();
        }
        return constants;
    }

    private MemberInfoConstants() {
        super("https://api.worldoftanks.ru/wot/regularteams/memberinfo");
        List<String> data = Collections.singletonList(ACCOUNT_ID_PARAM);
        addBasicApiConstants(data);
        addRequiredParams(data);
    }

}
