package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 16/11/2016.
 */
public class VehicleParamBuilder extends QueryParamBuilder {

    public static VehicleParamBuilder newBuilder() {
        return new VehicleParamBuilder();
    }

    public VehicleParamBuilder withTankId(long tankId) {
        return (VehicleParamBuilder) customParam(WOTAPIConstants.TANK_ID_PARAM, tankId);
    }

    public VehicleParamBuilder withTankIds(List<Integer> tanksIds) {
        if (Objects.nonNull(tanksIds) && tanksIds.isEmpty()) {
            return (VehicleParamBuilder) customParam(WOTAPIConstants.TANK_ID_PARAM, tanksIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));
        }
        return this;
    }
}
