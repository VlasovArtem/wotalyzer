package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.personal_mission;

import java.util.List;

/**
 * Created by artemvlasov on 10/10/16.
 */
public class OperationReward {

    /* Слоты */
    private int slots;
    /* Идентификаторы техники */
    private List<Integer> tanks;

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public List<Integer> getTanks() {
        return tanks;
    }

    public void setTanks(List<Integer> tanks) {
        this.tanks = tanks;
    }
}
