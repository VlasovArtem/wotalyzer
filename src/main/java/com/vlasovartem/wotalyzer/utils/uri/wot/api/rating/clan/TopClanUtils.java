package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.TopClan;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.TopClanConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class TopClanUtils extends MainUtils<TopClan> {

    @Override
    protected Class getType() {
        return TopClan.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return TopClanConstants.BASIC_URL;
}

    @Override
    public List<String> getAPIConstants() {
        return TopClanConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TopClanConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimitWithMax(1000, 10));
    }

}
