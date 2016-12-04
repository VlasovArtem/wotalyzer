package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Info;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.InfoConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class InfoUtils extends MainUtils<Info> {

    public Optional<Info> getInfo() {
        return getApiResponse("").getContent();
    }

    @Override
    protected Class<Info> getType() {
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
