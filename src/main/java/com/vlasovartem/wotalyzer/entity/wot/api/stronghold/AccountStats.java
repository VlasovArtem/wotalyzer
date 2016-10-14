package com.vlasovartem.wotalyzer.entity.wot.api.stronghold;

import com.vlasovartem.wotalyzer.entity.wot.api.stronghold.components.StrongholdData;

/**
 * Created by artemvlasov on 14/10/2016.
 */
public class AccountStats {

    /* Player account ID */
    private int accountId;
    /* Player clan ID */
    private int clanId;
    /* Total amount of Industrial Resource earned by player */
    private int totalResourcesEarned;
    /* Industrial Resource earned by player per week */
    private int weekResourcesEarned;
    /* Player's battle stats in the current clan's Stronghold defense. If player's clan has no Stronghold, field value is null. */
    private StrongholdData strongholdDefense;
    /* stronghold_skirmish - Player's battle stats in the current clan's Skirmishes. If player's clan has no Stronghold, field value is null. */
    private StrongholdData strongholdSkirmish;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getClanId() {
        return clanId;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public int getTotalResourcesEarned() {
        return totalResourcesEarned;
    }

    public void setTotalResourcesEarned(int totalResourcesEarned) {
        this.totalResourcesEarned = totalResourcesEarned;
    }

    public int getWeekResourcesEarned() {
        return weekResourcesEarned;
    }

    public void setWeekResourcesEarned(int weekResourcesEarned) {
        this.weekResourcesEarned = weekResourcesEarned;
    }

    public StrongholdData getStrongholdDefense() {
        return strongholdDefense;
    }

    public void setStrongholdDefense(StrongholdData strongholdDefense) {
        this.strongholdDefense = strongholdDefense;
    }

    public StrongholdData getStrongholdSkirmish() {
        return strongholdSkirmish;
    }

    public void setStrongholdSkirmish(StrongholdData strongholdSkirmish) {
        this.strongholdSkirmish = strongholdSkirmish;
    }
}
