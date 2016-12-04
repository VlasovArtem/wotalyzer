package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleConfiguration;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleConfigurationConstants;
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
public class VehicleConfigurationUtils extends MainUtils<VehicleConfiguration> {


    @Override
    protected Class<VehicleConfiguration> getType() {
        return VehicleConfiguration.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleConfigurationConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleConfigurationConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleConfigurationConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateOrderByParameter());
    }
}
