package com.vlasovartem.wotalyzer.utils.api.contstans.global_map;

import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.utils.ConstantUtils;

import java.util.List;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public interface SeasonClanInfoConstants extends BasicAPIConstants {

    String BASIC_URL = "https://developers.wargaming.net/reference/all/wot/globalmap/seasonclaninfo";
//    /* numeric Clan ID */
//    String CLAN_ID_PARAM = "clan_id";
//    /* string Season ID */
//    String SEASON_ID_PARAM = "season_id";
//    /* string, list List of vehicle Tiers. Valid values: "6" — Vehicles of Tier 6 "8" — Vehicles of Tier 8 "10" — Vehicles of Tier 10 */
//    String VEHICLE_LEVEL_PARAM = "vehicle_level";
    List<String> BASIC_API_CONSTANTS = ConstantUtils.generate(BasicAPIConstants.BASIC_API_CONSTANTS, CLAN_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM);
    List<String> REQUIRED_PARAMS = ConstantUtils.generate(BasicAPIConstants.REQUIRED_PARAMS, CLAN_ID_PARAM, SEASON_ID_PARAM, VEHICLE_LEVEL_PARAM);

}
