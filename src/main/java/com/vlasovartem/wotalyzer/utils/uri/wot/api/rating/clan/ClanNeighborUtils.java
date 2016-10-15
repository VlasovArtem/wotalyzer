package com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanNeighborConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanNeighborUtils extends MainUtils<ClanNeighbor> {

    public ClanNeighborUtils() {
        super(ClanNeighbor.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanNeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimitWithMax(50, 5));
    }

}
