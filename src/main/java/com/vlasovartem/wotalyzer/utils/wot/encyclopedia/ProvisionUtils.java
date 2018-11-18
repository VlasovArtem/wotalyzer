package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Provision;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ProvisionType;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.ProvisionConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.EncyclopediaParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class ProvisionUtils extends MainUtils<Provision> {

    public List<Provision> getProvisions() {
        return convertMapToList(getApiResponseMap(""));
    }

    public Optional<Provision> getProvision(long provisionId) {
        APIResponse<Provision> apiResponse = getApiResponse(EncyclopediaParamBuilder.newBuilder().withProvisionId(provisionId).build());
        return apiResponse.getContent();
    }

    public List<Provision> getProvision(ProvisionType type) {
        return convertMapToList(getApiResponseMap(EncyclopediaParamBuilder.newBuilder().withProvisionType(type).build()));
    }

    @Override
    protected Class<Provision> getType() {
        return Provision.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ProvisionConstants.getInstance();
    }
}
