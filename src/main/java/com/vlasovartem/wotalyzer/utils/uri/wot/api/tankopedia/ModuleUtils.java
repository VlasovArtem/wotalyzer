package com.vlasovartem.wotalyzer.utils.uri.wot.api.tankopedia;

import com.vlasovartem.wotalyzer.entity.wot.api.tankopedia.Module;
import com.vlasovartem.wotalyzer.utils.api.contstans.tankopedia.ModuleConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import com.vlasovartem.wotalyzer.utils.validators.tankopedia.DataValidator;

import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.MODULE_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TYPE_PARAM;

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
    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if(checkRequiredFields(queryParams)) {
            for (Map.Entry<String, Object> entrySet : queryParams.entrySet()) {
                switch (entrySet.getKey()) {
                    case MODULE_ID_PARAM:
                        if (!DataValidator.validateModuleId((Integer) entrySet.getValue())) {
                            return false;
                        }
                        break;
                    case TYPE_PARAM:
                        if (!DataValidator.validateType((String) entrySet.getValue())) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}
