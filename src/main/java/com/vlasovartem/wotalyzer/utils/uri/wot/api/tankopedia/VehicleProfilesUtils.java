package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.VehicleProfiles;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.VehicleProfilesConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class VehicleProfilesUtils extends MainUtils<VehicleProfiles> {

    public VehicleProfilesUtils() {
        super(VehicleProfiles.class);
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
}
