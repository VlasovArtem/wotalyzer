package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_mission;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public class Rewards {

    private MissionReward primary;
    private MissionReward secondary;

    public MissionReward getPrimary() {
        return primary;
    }

    public void setPrimary(MissionReward primary) {
        this.primary = primary;
    }

    public MissionReward getSecondary() {
        return secondary;
    }

    public void setSecondary(MissionReward secondary) {
        this.secondary = secondary;
    }
}
