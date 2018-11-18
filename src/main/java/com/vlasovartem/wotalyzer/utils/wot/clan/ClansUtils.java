package com.vlasovartem.wotalyzer.utils.wot.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.clan.Clan;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.clan.ClansConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.clan.ClanValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 13/12/2016.
 */
@Component
public class ClansUtils extends MainUtils<Clan> {

    public List<Clan> getClans(String name) {
        APIResponse<List<Clan>> wot = getApiResponseList(ClanParamBuilder.newBuilder().withName(name).customParam(WOTAPIConstants.GAME_PARAM, "wot").build());
        return wot.getContent().orElse(Collections.emptyList());
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return ClansConstants.getInstance();
    }

    @Override
    protected Class<Clan> getType() {
        return Clan.class;
    }

    @Override
    protected List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(ClanValidator.validateName());
    }
}
