package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerVehicles;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerVehiclesConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayerVehiclesUtils extends MainUtils<PlayerVehicles> {

    public PlayerVehiclesUtils() {
        super(PlayerVehicles.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return PlayerVehiclesConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlayerVehiclesConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlayerVehiclesConstants.REQUIRED_PARAMS;
    }
}
