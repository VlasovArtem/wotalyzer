package com.vlasovartem.wotalyzer.utils.wot.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.PlayerVehicles;
import com.vlasovartem.wotalyzer.entity.wot.api.account.components.PlayerVehicleData;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.account.PlayerVehiclesConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.QueryParamExtBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by artemvlasov on 14/10/2016.
 */
@Component
public class PlayerVehiclesUtils extends MainUtils<PlayerVehicleData> {

    public Optional<PlayerVehicles> getPlayerVehicles(long accountId) {
        APIResponse<Map<String, List<PlayerVehicleData>>> playerVehicleDataResponse = getApiResponseMapList(QueryParamExtBuilder.newBuilder().withAccountId(accountId).build());
        Optional<Map<String, List<PlayerVehicleData>>> content = playerVehicleDataResponse.getContent();
        if (content.isPresent()) {
            PlayerVehicles playerVehicles = new PlayerVehicles();
            playerVehicles.setId(accountId);
            playerVehicles.setPlayerVehicleData(content.get().get(String.valueOf(accountId)));
            return Optional.of(playerVehicles);
        }
        return Optional.empty();
    }

    @Override
    protected Class<PlayerVehicleData> getType() {
        return PlayerVehicleData.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return PlayerVehiclesConstants.getInstance();
    }
}
