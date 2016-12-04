package com.vlasovartem.wotalyzer.utils.query.builder;

import com.vlasovartem.wotalyzer.entity.wot.api.enums.ClanRankField;

import java.util.Objects;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 22/11/2016.
 */
public class ClanParamBuilder extends QueryParamBuilder {

    public static ClanParamBuilder newBuilder() {
        if (Objects.isNull(builder)) {
            builder = new ClanParamBuilder();
        }
        return (ClanParamBuilder) builder;
    }

    private ClanParamBuilder() {
        super();
    }

    public ClanParamBuilder withClanId(int clanId) {
        return (ClanParamBuilder) customParam(CLAN_ID_PARAM, clanId);
    }

    public ClanParamBuilder withFrontId(String frontId) {
        return (ClanParamBuilder) customParam(FRONT_ID_PARAM, frontId);
    }

    public ClanParamBuilder withSeasonId(String seasonId) {
        return (ClanParamBuilder) customParam(SEASON_ID_PARAM, seasonId);
    }

    public ClanParamBuilder withVehicleLevel(int vehicleLevel) {
        return (ClanParamBuilder) customParam(VEHICLE_LEVEL_PARAM, vehicleLevel);
    }

    public ClanParamBuilder withEventId(String eventId) {
        return (ClanParamBuilder) customParam(EVENT_ID_PARAM, eventId);
    }

    public ClanParamBuilder withRankField(ClanRankField field) {
        return (ClanParamBuilder) customParam(RANK_FIELD_PARAM, field.getValue());
    }
}
