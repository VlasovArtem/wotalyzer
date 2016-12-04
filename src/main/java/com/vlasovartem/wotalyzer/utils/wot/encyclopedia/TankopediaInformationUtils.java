package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.TankopediaInformation;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.TankopediaInformationConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 09/10/16.
 */
@Component
public class TankopediaInformationUtils extends MainUtils<TankopediaInformation> {

    public Optional<TankopediaInformation> getInfo() {
        APIResponse<TankopediaInformation> informationAPIResponse = getApiResponse(Collections.emptyMap());
        return informationAPIResponse.getContent();
    }

    @Override
    protected Class<TankopediaInformation> getType() {
        return TankopediaInformation.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return TankopediaInformationConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TankopediaInformationConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TankopediaInformationConstants.REQUIRED_PARAMS;
    }
}
