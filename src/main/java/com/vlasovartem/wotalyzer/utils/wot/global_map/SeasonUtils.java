package com.vlasovartem.wotalyzer.utils.wot.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.Season;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.global_map.SeasonConstants;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;

import java.util.*;
import java.util.function.Function;

import static com.vlasovartem.wotalyzer.utils.query.builder.ClanParamBuilder.newBuilder;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validateLimit;
import static com.vlasovartem.wotalyzer.utils.validators.MainValidator.validatePageNoParameter;
import static com.vlasovartem.wotalyzer.utils.validators.global_map.GlobalMapValidator.validateStatusParameter;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class SeasonUtils extends MainUtils<Season> {

    public List<Season> getSeasons() {
        APIResponse<List<Season>> apiResponse = getApiResponseList("");
        Optional<List<Season>> content = apiResponse.getContent();
        return content.orElse(Collections.emptyList());
    }

    public Optional<Season> getSeason(String seasonId) {
        APIResponse<List<Season>> apiResponse = getApiResponseList(newBuilder().withSeasonId(seasonId).build());
        Optional<List<Season>> content = apiResponse.getContent();
        if (content.isPresent()) {
            return content.get().stream().findFirst();
        }
        return Optional.empty();
    }

    @Override
    protected Class<Season> getType() {
        return Season.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return SeasonConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return SeasonConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return SeasonConstants.REQUIRED_PARAMS;
    }

    @Override
    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Arrays.asList(validateLimit(1, 20, 5), validatePageNoParameter(), validateStatusParameter());
    }
}
