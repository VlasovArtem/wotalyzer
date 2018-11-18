package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by artemvlasov on 15/10/2016.
 * https://developers.wargaming.net/reference/all/wot/globalmap/seasonaccountinfo/
 */
public class SeasonAccountInfo {
    
    /* seasons - Account information by seasons and vehicle Tiers */
    private List<Season> seasons;
    
    private class Season {
        /* Account ID */
        private int accountId;
        /* Award level */
        private String awardLevel;
        /* Battles fought for current clan */
        private int battles;
        /* Battles to fight in a current clan to get clan award for the season */
        private int battlesToAward;
        /* Clan ID */
        private int clanId;
        /* Clan rating */
        private int clanRank;
        /* Season ID */
        private String seasonId;
        /* Date when account data were updated */
        private LocalDateTime updatedAt;
        /* Vehicle Tier */
        private int vehicleLevel;

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getAwardLevel() {
            return awardLevel;
        }

        public void setAwardLevel(String awardLevel) {
            this.awardLevel = awardLevel;
        }

        public int getBattles() {
            return battles;
        }

        public void setBattles(int battles) {
            this.battles = battles;
        }

        public int getBattlesToAward() {
            return battlesToAward;
        }

        public void setBattlesToAward(int battlesToAward) {
            this.battlesToAward = battlesToAward;
        }

        public int getClanId() {
            return clanId;
        }

        public void setClanId(int clanId) {
            this.clanId = clanId;
        }

        public int getClanRank() {
            return clanRank;
        }

        public void setClanRank(int clanRank) {
            this.clanRank = clanRank;
        }

        public String getSeasonId() {
            return seasonId;
        }

        public void setSeasonId(String seasonId) {
            this.seasonId = seasonId;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getVehicleLevel() {
            return vehicleLevel;
        }

        public void setVehicleLevel(int vehicleLevel) {
            this.vehicleLevel = vehicleLevel;
        }
    }
    
}
