package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.WotMap;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.WOTMapConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class WOTMapUtils extends MainUtils<WotMap> {

    public List<WotMap> getWOTMaps() {
        return convertMapToList(getApiResponseMap(Collections.emptyMap()));
    }

    @Override
    protected Class<WotMap> getType() {
        return WotMap.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return WOTMapConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return WOTMapConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return WOTMapConstants.REQUIRED_PARAMS;
    }
}
