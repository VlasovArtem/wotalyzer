package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanType;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanTypeConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class ClanTypeUtils extends MainUtils<ClanType> {

    @Override
    protected Class getType() {
        return ClanType.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanTypeConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanTypeConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanTypeConstants.REQUIRED_PARAMS;
    }
}
