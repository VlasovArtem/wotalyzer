package com.vlasovartem.wotalyzer.controller;

import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;
import com.vlasovartem.wotalyzer.entity.wot.api.account.Players;
import com.vlasovartem.wotalyzer.entity.wot.api.rating.Account;
import com.vlasovartem.wotalyzer.service.wn8.AccountWN8Service;
import com.vlasovartem.wotalyzer.utils.api.contstans.enums.NameTypeParameter;
import com.vlasovartem.wotalyzer.utils.api.contstans.enums.RatingTypeParameter;
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

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 18/10/2016.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final PlayersUtils playersUtils;
    private final PlayerUtils playerUtils;
    private final AccountUtils accountUtils;
    private final AccountWN8Service accountWN8Service;

    @Autowired
    public TestController(PlayersUtils playersUtils, PlayerUtils playerUtils, AccountUtils accountUtils, AccountWN8Service accountWN8Service) {
        this.playersUtils = playersUtils;
        this.playerUtils = playerUtils;
        this.accountUtils = accountUtils;
        this.accountWN8Service = accountWN8Service;
    }

    @RequestMapping("/get")
    public ResponseEntity<List<Players>> test(@RequestParam String name) {
        List<Players> playersByName = playersUtils.findPlayersByName(name, NameTypeParameter.EXACT);
        return ResponseEntity.ok(playersByName);
    }

    @RequestMapping("/player")
    public ResponseEntity player(@RequestParam int id) {
        try {
            return ResponseEntity.ok(playerUtils.getPlayer(id));
        } catch (WotAPIException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping("/rating")
    public ResponseEntity rating(@RequestParam int id) {
        Optional<Account> account = accountUtils.getAccount(id, RatingTypeParameter.TYPE_ALL);
        return ResponseEntity.ok(account);
    }

    @RequestMapping("/wn8")
    public ResponseEntity wn8(@RequestParam int id) {
        AccountWN8 accountWN8 = accountWN8Service.getAccountWN8(id);
        return ResponseEntity.ok(accountWN8);
    }

}
