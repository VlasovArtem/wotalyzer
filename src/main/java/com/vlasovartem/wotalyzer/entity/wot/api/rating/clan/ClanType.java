package com.vlasovartem.wotalyzer.entity.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.VehicleMainEntity;

import java.util.List;

/**
 * Created by artemvlasov on 13/10/2016.
 * https://developers.wargaming.net/reference/all/wot/clanratings/types
 */
public class ClanType extends VehicleMainEntity {

    /* rank_fields - Категории рейтинга */
    private List<String> rankFields;
    /* Период формирования рейтинга */
    private String type;


}
