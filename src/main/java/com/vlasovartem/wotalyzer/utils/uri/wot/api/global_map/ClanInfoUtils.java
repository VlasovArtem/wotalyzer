package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanInfo;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanInfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanInfoUtils extends MainUtils<ClanInfo> {

    public ClanInfoUtils() {
        super(ClanInfo.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanInfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanInfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanInfoConstants.REQUIRED_PARAMS;
    }
}
