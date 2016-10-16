package com.vlasovartem.wotalyzer.entity.wot.api.global_map.components;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public class ActiveBattle {

    /* AwardWarning. The field will be disabled. */
    private int battleReward;
    /* Round */
    private int round;
    /* Battle start time in UTC */
    private String startAt;
    /* First challenging clan ID */
    private Clan clanA;
    /* Second challenging clan ID */
    private Clan clanB;
    
    private class Clan {
        /* Award */
        private int battleReward;
        /* Clan ID */
        private int clanId;
        /* Changes in Elo-rating due to defeat */
        private int looseEloDelta;
        /* Changes in Elo-rating due to victory */
        private int winEloDelta;

        public int getBattleReward() {
            return battleReward;
        }

        public void setBattleReward(int battleReward) {
            this.battleReward = battleReward;
        }

        public int getClanId() {
            return clanId;
        }

        public void setClanId(int clanId) {
            this.clanId = clanId;
        }

        public int getLooseEloDelta() {
            return looseEloDelta;
        }

        public void setLooseEloDelta(int looseEloDelta) {
            this.looseEloDelta = looseEloDelta;
        }

        public int getWinEloDelta() {
            return winEloDelta;
        }

        public void setWinEloDelta(int winEloDelta) {
            this.winEloDelta = winEloDelta;
        }
    }

    public int getBattleReward() {
        return battleReward;
    }

    public void setBattleReward(int battleReward) {
        this.battleReward = battleReward;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public Clan getClanA() {
        return clanA;
    }

    public void setClanA(Clan clanA) {
        this.clanA = clanA;
    }

    public Clan getClanB() {
        return clanB;
    }

    public void setClanB(Clan clanB) {
        this.clanB = clanB;
    }
}
