package com.vlasovartem.wotalyzer.utils.uri.wot.api.account;

import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.utils.api.contstans.player.PlayerConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by artemvlasov on 06/10/16.
 */
@Component
public class PlayerUtils extends MainUtils<Player> {

    public PlayerUtils() {
        super(Player.class);
    }

    @Override
    public String getAPIBaseUrl() {
        return PlayerConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return PlayerConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return PlayerConstants.REQUIRED_PARAMS;
    }
}
