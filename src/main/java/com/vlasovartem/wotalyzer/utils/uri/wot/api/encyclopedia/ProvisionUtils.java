package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Provision;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.ProvisionConstants;
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
public class ProvisionUtils extends MainUtils<Provision> {

    @Override
    protected Class getType() {
        return Provision.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ProvisionConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ProvisionConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ProvisionConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateProvisionTypeParameter());
    }
}
