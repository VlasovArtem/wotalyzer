package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.booster.Booster;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.BoosterConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 11/10/16.
 */
public class BoosterUtils extends MainUtils<Booster> {

    public BoosterUtils() {
        super(Booster.class);
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
