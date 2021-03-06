package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment;

import com.vlasovartem.wotalyzer.entity.wot.api.VehicleMainEntity;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Suspension extends VehicleMainEntity {

    private int loadLimit;
    private int traverseSpeed;

    public int getLoadLimit() {
        return loadLimit;
    }

    public void setLoadLimit(int loadLimit) {
        this.loadLimit = loadLimit;
    }

    public int getTraverseSpeed() {
        return traverseSpeed;
    }

    public void setTraverseSpeed(int traverseSpeed) {
        this.traverseSpeed = traverseSpeed;
    }
}
