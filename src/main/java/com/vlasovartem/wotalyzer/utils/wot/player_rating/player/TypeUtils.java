package com.vlasovartem.wotalyzer.utils.wot.player_rating.player;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.BattleType;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.player.Type;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.TypeConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.QueryParamBuilder;
import com.vlasovartem.wotalyzer.utils.response.APIResponseUtils;
import com.vlasovartem.wotalyzer.utils.wot.player_rating.RatingUtils;

import java.util.List;

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
                        QueryParamBuilder.newBuilder().customParam(WOTAPIConstants.BATTLE_TYPE_PARAM, battleType.getValue()).build()));
    }

    @Override
    protected Class<Type> getType() {
        return Type.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return TypeConstants.getInstance();
    }
}
