package com.vlasovartem.wotalyzer.utils.uri.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanBattle;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanBattleConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanBattleUtils extends MainUtils<ClanBattle> {

    @Override
    protected Class getType() {
        return ClanBattle.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanBattleConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanBattleConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanBattleConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(0, 100, 100), validatePageNoParameter());
    }
}
