package com.vlasovartem.wotalyzer.utils.wot.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanType;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanTypeConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class ClanTypeUtils extends MainUtils<ClanType> {

    public List<ClanType> getClanTypes() {
        return convertMapToList(getApiResponseMap(""));
    }

    @Override
    protected Class<ClanType> getType() {
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
