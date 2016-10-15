package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.Module;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.ModuleConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.tankopedia.DataValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 11/10/16.
 */
public class ModuleUtils extends MainUtils<Module> {

    public ModuleUtils() {
        super(Module.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return ModuleConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ModuleConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ModuleConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(DataValidator.validateType(), DataValidator.validateModuleId());
    }

}
