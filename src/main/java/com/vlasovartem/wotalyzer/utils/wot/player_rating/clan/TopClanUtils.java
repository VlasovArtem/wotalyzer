package com.vlasovartem.wotalyzer.utils.wot.player_rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ClanRankField;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.TopClan;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan.TopClanConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class TopClanUtils extends MainUtils<TopClan> {

    public List<TopClan> getTopClans(@NotNull ClanRankField field) {
        return getApiResponseList(
                ClanParamBuilder.newBuilder()
                        .withRankField(field)
                        .build())
                .getContent().orElse(Collections.emptyList());
    }

    @Override
    protected Class<TopClan> getType() {
        return TopClan.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return TopClanConstants.getInstance();
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimitWithMax(1000, 10));
    }

}
