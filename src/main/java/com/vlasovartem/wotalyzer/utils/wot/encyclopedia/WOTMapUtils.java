package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.WotMap;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
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
    protected BasicAPIConstants getAPIConstants() {
        return WOTMapConstants.getInstance();
    }
}
