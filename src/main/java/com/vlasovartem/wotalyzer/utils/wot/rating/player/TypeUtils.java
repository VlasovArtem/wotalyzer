package com.vlasovartem.wotalyzer.utils.wot.rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.Type;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.rating.TypeConstants;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.rating.RatingUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder.newBuilder;

/**
 * Created by artemvlasov on 11/10/2016.
 */
public class TypeUtils extends RatingUtils<Type> {

    public List<Type> getTypes() {
        return APIResponseUtils.convertMapToList(getApiResponseMap(""));
    }

    public List<Type> getTypes(BattleType battleType) {
        return APIResponseUtils.convertMapToList(
                getApiResponseMap(
                        newBuilder().customParam(WOTAPIConstants.BATTLE_TYPE_PARAM, battleType.getValue()).build()));
    }

    @Override
    protected Class<Type> getType() {
        return Type.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return TypeConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return TypeConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return TypeConstants.REQUIRED_PARAMS;
    }


}
