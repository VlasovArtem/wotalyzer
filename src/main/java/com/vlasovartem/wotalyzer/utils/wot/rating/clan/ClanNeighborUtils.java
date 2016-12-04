package com.vlasovartem.wotalyzer.utils.wot.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ClanRankField;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.clan.ClanNeighbor;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan.ClanNeighborConstants;
import com.vlasovartem.wotalyzer.utils.validators.MainValidator;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanNeighborUtils extends MainUtils<ClanNeighbor> {

    public List<ClanNeighbor> getClanNeighbors(@NotNull int clanId, @NotNull ClanRankField field) {
        return getApiResponseList(
                newBuilder()
                        .withClanId(clanId)
                        .withRankField(field)
                        .build())
                .getContent()
                .orElse(Collections.emptyList());
    }

    @Override
    protected Class<ClanNeighbor> getType() {
        return ClanNeighbor.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return ClanNeighborConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return ClanNeighborConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return ClanNeighborConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.singletonList(MainValidator.validateLimitWithMax(50, 5));
    }

}
