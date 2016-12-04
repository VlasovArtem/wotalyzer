package com.vlasovartem.wotalyzer.utils.wot.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.ClanStronghold;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.stronghold.ClanStrongholdConstants;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class ClanStrongholdUtils extends MainUtils<ClanStronghold> {

    @Override
    protected Class getType() {
        return ClanStronghold.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanStrongholdConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanStrongholdConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanStrongholdConstants.REQUIRED_PARAMS;
    }
}
