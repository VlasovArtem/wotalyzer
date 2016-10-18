package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.info.Info;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.InfoConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component
public class InfoUtils extends MainUtils<Info> {

    InfoUtils() {
        super(Info.class);
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
