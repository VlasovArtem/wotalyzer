package com.vlasovartem.wotalyzer.utils.wot.teams;

import com.vlasovartem.wotalyzer.entity.wot.api.teams.MemberInfo;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.teams.MemberInfoConstants;

import java.util.List;

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
    public String getAPIBaseUrl() {
        return MemberInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return MemberInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return MemberInfoConstants.REQUIRED_PARAMS;
    }
}
