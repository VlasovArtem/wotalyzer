package com.vlasovartem.wotalyzer.utils.api.contstans.player_rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;

import java.util.Arrays;
import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public class ClanNeighborConstants extends BasicAPIConstants {

    private static ClanNeighborConstants constants;

    public static ClanNeighborConstants getInstance() {
        if (Objects.isNull(constants)) {
            constants = new ClanNeighborConstants();
        }
        return constants;
    }

    private ClanNeighborConstants() {
        super("https://api.worldoftanks.ru/wot/clanratings/neighbors");
        addBasicApiConstants(Arrays.asList(CLAN_ID_PARAM, RANK_FIELD_PARAM, DATE_PARAM, LIMIT_PARAM));
        addRequiredParams(Arrays.asList(CLAN_ID_PARAM, RANK_FIELD_PARAM));
    }

}
