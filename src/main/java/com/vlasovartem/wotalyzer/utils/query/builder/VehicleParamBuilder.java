package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.VehicleType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 16/11/2016.
 */
public class VehicleParamBuilder extends QueryParamBuilder {

    public static VehicleParamBuilder newBuilder() {
        return new VehicleParamBuilder();
    }

    private VehicleParamBuilder() {
        super();
    }

    public VehicleParamBuilder withTankId(long tankId) {
        return (VehicleParamBuilder) customParam(TANK_ID_PARAM, tankId);
    }

    public VehicleParamBuilder withTankIds(List<Long> tanksIds) {
        if (Objects.nonNull(tanksIds) && !tanksIds.isEmpty()) {
            return (VehicleParamBuilder) customParam(TANK_ID_PARAM, tanksIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")));
        }
        return this;
    }

    public VehicleParamBuilder withVehicleType(VehicleType type) {
        return (VehicleParamBuilder) customParam(TYPE_PARAM, type.getValue());
    }

    public VehicleParamBuilder withNation(Nation nation) {
        return (VehicleParamBuilder) customParam(NATION_PARAM, nation.name().toLowerCase());
    }

    public VehicleParamBuilder withTier(int tier) {
        return (VehicleParamBuilder) customParam(TIER_PARAM, tier);
    }
}
