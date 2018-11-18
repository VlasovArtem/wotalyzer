package com.vlasovartem.wotalyzer.utils.wot.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.MemberInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.MemberInfoConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class MemberInfoUtils extends MainUtils<MemberInfo> {

    //TODO

    @Override
    protected Class<MemberInfo> getType() {
        return MemberInfo.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return MemberInfoConstants.getInstance();
    }
}
