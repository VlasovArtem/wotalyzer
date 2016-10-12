package com.vlasovartem.wotalyzer.utils.api.contstans.rating.clan;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

/**
 * Created by artemvlasov on 12/10/2016.
 */
public interface ClanRatingConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/clanratings/clans";
    /* numeric, list Идентификаторы кланов */
    String CLAN_ID_PARAM = "clan_id";
    /* timestamp/date Дата расчёта рейтингов. Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00 */
    String DATE_PARAM = "date";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CLAN_ID_PARAM, DATE_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, CLAN_ID_PARAM);

}
