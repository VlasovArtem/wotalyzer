package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfiles;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleProfilesConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class VehicleProfilesUtils extends MainUtils<VehicleProfiles> {

    @Override
    protected Class getType() {
        return VehicleProfiles.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleProfilesConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleProfilesConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleProfilesConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateOrderByParameter());
    }
}
