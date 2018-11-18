package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Module;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.ModuleType;
import com.vlasovartem.wotalyzer.entity.wot.api.enums.Nation;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.ModuleConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.EncyclopediaParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.encyclopedia.EncyclopediaValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;

/**
 * Created by artemvlasov on 11/10/16.
 */
@Component
public class ModuleUtils extends MainUtils<Module> {

    public List<Module> getModule(Nation nation, ModuleType moduleType) {
        return convertMapToList(getApiResponseMap(EncyclopediaParamBuilder.newBuilder()
                .withModuleType(moduleType)
                .withNation(nation)
                .build()));
    }

    @Override
    protected Class<Module> getType() {
        return Module.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ModuleConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(EncyclopediaValidator.validateModulesTypeParameter(), EncyclopediaValidator.validateModuleIdParameter(), EncyclopediaValidator.validateExtraParameter());
    }

}
