package com.vlasovartem.wotalyzer.controller;

import com.vlasovartem.wotalyzer.entity.wot.api.response.AbstractAPIResponse;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Player;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.Account;
import com.vlasovartem.wotalyzer.utils.exception.WotAPIException;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.account.PlayerUtils;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.account.PlayersUtils;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.rating.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Created by artemvlasov on 18/10/2016.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final PlayersUtils playersUtils;
    private final PlayerUtils playerUtils;
    private final AccountUtils accountUtils;

    @Autowired
    public TestController(PlayersUtils playersUtils, PlayerUtils playerUtils, AccountUtils accountUtils) {
        this.playersUtils = playersUtils;
        this.playerUtils = playerUtils;
        this.accountUtils = accountUtils;
    }

    @RequestMapping("/get")
    public ResponseEntity<List<Players>> test(@RequestParam String name) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(TYPE_PARAM, "exact");
        objectMap.put(SEARCH_PARAM, name);
        AbstractAPIResponse<List<Players>> apiResponse = playersUtils.getApiResponseList(objectMap);
        return ResponseEntity.ok(apiResponse.getData());
    }

    @RequestMapping("/player")
    public ResponseEntity player(@RequestParam int id) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(ACCOUNT_ID_PARAM, id);
        try {
            AbstractAPIResponse<Map<String, Player>> apiResponse = playerUtils.getApiResponseMap(objectMap);
            Map<String, Player> data = apiResponse.getData();
            return ResponseEntity.ok(data.values().stream().findFirst().orElse(null));
        } catch (WotAPIException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping("/rating")
    public ResponseEntity rating(@RequestParam int id) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(ACCOUNT_ID_PARAM, id);
        objectMap.put(TYPE_PARAM, "all");
        AbstractAPIResponse<Map<String, Account>> apiResponse = accountUtils.getApiResponseMap(objectMap);
        Map<String, Account> data = apiResponse.getData();
        return ResponseEntity.ok(data.values().stream().findFirst().orElse(null));
    }

}
