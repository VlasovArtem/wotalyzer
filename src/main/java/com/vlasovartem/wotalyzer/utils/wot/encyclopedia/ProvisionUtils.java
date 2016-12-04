package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Provision;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ProvisionType;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.ProvisionConstants;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.PROVISION_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;
import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class ProvisionUtils extends MainUtils<Provision> {

    public List<Provision> getProvisions() {
        return convertMapToList(getApiResponseMap(""));
    }

    public Optional<Provision> getProvision(int provisionId) {
        APIResponse<Provision> apiResponse = getApiResponse(newBuilder().customParam(PROVISION_ID_PARAM, provisionId).build());
        return apiResponse.getContent();
    }

    public List<Provision> getProvision(ProvisionType type) {
        return convertMapToList(getApiResponseMap(newBuilder().customParam(TYPE_PARAM, type.getValue()).build()));
    }

    @Override
    protected Class<Provision> getType() {
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
