package com.vlasovartem.wotalyzer.entity.wot.api.player_vehicles.components;

import com.vlasovartem.wotalyzer.entity.wot.api.account.components.statistics.AverageStatisticsData;

/**
 * Created by artemvlasov on 13/10/2016.
 */
public class FalloutStatistic extends AverageStatisticsData {

    /* Damage caused by Combat Reserves */
    private int avatarDamageDealt;
    /* Destroyed by Combat Reserves */
    private int avatarFrags;
    /* Deaths */
    private int deathCount;
    /* Flags captured in platoon */
    private int flagCapture;
    /* Flags captured as solo player */
    private int flagCaptureSolo;
    /* Maximum damage caused in one battle including damage from avatar */
    private int maxDamageWithAvatar;
    /* Maximum destroyed in one battle including vehicles destroyed by avatar */
    private int maxFragsWithAvatar;
    /* Maximum Victory points earned in Fallout */
    private int maxWinPoints;
    /* Resources captured at resource points */
    private int resourceAbsorbed;
    /* Victory points */
    private int winPoints;
    /* Maximum Damage caused per battle */
    private int maxDamage;
    /* Maximum destroyed in battle */
    private int maxFrags;
    /* Maximum experience per battle */
    private int maxXp;

}
