package com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.equipment;

import com.vlasovartem.wotalyzer.entity.wot.api.BasicApi;

/**
 * Created by artemvlasov on 13/01/16.
 */
public class Radio extends BasicApi {

    private int signalRange;

    public int getSignalRange() {
        return signalRange;
    }

    public void setSignalRange(int signalRange) {
        this.signalRange = signalRange;
    }
}
