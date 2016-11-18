package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.booster.Booster;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.BoosterConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 */
@Component
public class BoosterUtils extends MainUtils<Booster> {

    @Override
    protected Class getType() {
        return Booster.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return BoosterConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return BoosterConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return BoosterConstants.REQUIRED_PARAMS;
    }
}
