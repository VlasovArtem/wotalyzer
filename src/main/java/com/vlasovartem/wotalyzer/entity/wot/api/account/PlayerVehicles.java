package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.PlayerVehicleData;

import java.util.List;

/**
 * Created by artemvlasov on 10/09/16.
 */
public class PlayerVehicles extends MainEntity {

    private List<PlayerVehicleData> playerVehicleData;

    public List<PlayerVehicleData> getPlayerVehicleData() {
        return playerVehicleData;
    }

    public void setPlayerVehicleData(List<PlayerVehicleData> playerVehicleData) {
        this.playerVehicleData = playerVehicleData;
    }
}
