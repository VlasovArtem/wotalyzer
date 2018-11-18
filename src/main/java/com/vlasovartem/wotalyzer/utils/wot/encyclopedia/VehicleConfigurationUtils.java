package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleConfiguration;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleConfigurationConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by artemvlasov on 10/10/16.
 */
@Component
public class VehicleConfigurationUtils extends MainUtils<VehicleConfiguration> {

    public Optional<VehicleConfiguration> getVehicleConfiguration(long tankId) {
        return APIResponseUtils.covertMapListToObject(getApiResponseMapList(VehicleParamBuilder.newBuilder().withTankId(tankId).build()));
    }

    @Override
    protected Class<VehicleConfiguration> getType() {
        return VehicleConfiguration.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return VehicleConfigurationConstants.getInstance();
    }

    @Override
    protected List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(EncyclopediaValidator.validateOrderByParameter());
    }
}
