package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.ClanBattle;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.ClanBattleConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class ClanBattleUtils extends MainUtils<ClanBattle> {

    public List<ClanBattle> getClanBattles(int clanId) {
        APIResponse<Map<String, List<ClanBattle>>> apiResponse = getApiResponseMapList(ClanParamBuilder.newBuilder().withClanId(clanId).build());
        Optional<Map<String, List<ClanBattle>>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return content.get().get(String.valueOf(clanId));
        }
        return Collections.emptyList();
    }

    @Override
    protected Class<ClanBattle> getType() {
        return ClanBattle.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClanBattleConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(0, 100, 100), validatePageNoParameter());
    }
}
