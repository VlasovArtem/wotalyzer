package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ModuleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ProvisionType;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 26/12/2016.
 */
public class EncyclopediaParamBuilder extends QueryParamBuilder {

    public static EncyclopediaParamBuilder newBuilder() {
        return new EncyclopediaParamBuilder();
    }

    private EncyclopediaParamBuilder() {
        super();
    }

    public EncyclopediaParamBuilder withNation(Nation nation) {
        return (EncyclopediaParamBuilder) customParam(NATION_PARAM, nation.name().toLowerCase());
    }

    public EncyclopediaParamBuilder withModuleType(ModuleType type) {
        return (EncyclopediaParamBuilder) customParam(TYPE_PARAM, type.getValue());
    }

    public EncyclopediaParamBuilder withProvisionId(long id) {
        return (EncyclopediaParamBuilder) customParam(PROVISION_ID_PARAM, id);
    }

    public EncyclopediaParamBuilder withProvisionType(ProvisionType type) {
        return (EncyclopediaParamBuilder) customParam(TYPE_PARAM, type.getValue());
    }

}
