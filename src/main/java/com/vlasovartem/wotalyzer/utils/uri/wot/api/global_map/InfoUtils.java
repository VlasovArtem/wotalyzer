package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Info;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.InfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class InfoUtils extends MainUtils<Info> {

    @Override
    protected Class getType() {
        return Info.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return InfoConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return InfoConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return InfoConstants.REQUIRED_PARAMS;
    }
}
