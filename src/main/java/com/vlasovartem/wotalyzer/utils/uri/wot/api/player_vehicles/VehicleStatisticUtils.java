package com.vlasovartem.wotalyzer.utils.uri.wot.api.player_vehicles;

import com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.VehicleStatistic;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_vehicles.VehicleStatisticConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class VehicleStatisticUtils extends MainUtils<VehicleStatistic> {

    public VehicleStatisticUtils() {
        super(VehicleStatistic.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleStatisticConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleStatisticConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleStatisticConstants.REQUIRED_PARAMS;
    }
}
