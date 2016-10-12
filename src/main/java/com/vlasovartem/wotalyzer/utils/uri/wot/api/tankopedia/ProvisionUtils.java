package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.provision.Provision;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.ProvisionConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class ProvisionUtils extends MainUtils<Provision> {

    public ProvisionUtils() {
        super(Provision.class);
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
}
