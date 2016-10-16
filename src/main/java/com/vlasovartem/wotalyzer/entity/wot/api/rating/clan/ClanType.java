package com.vlasovartem.wotalyzer.entity.wot.api.rating.clan;

import com.vlasovartem.wotalyzer.entity.wot.api.MainEntityExt;

import java.util.List;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class ClanType extends MainEntityExt {

    /* rank_fields - Категории рейтинга */
    private List<String> rankFields;
    /* Период формирования рейтинга */
    private String type;


}
