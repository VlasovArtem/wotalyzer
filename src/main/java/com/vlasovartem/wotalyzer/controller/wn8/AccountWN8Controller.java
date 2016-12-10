package com.vlasovartem.wotalyzer.controller.wn8;

import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;
import com.vlasovartem.wotalyzer.service.wn8.AccountWN8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by artemvlasov on 05/12/2016.
 */
@Controller
@RequestMapping("/wn8")
public class AccountWN8Controller {

    private final AccountWN8Service accountWN8Service;

    @Autowired
    public AccountWN8Controller(AccountWN8Service accountWN8Service) {
        this.accountWN8Service = accountWN8Service;
    }

    @RequestMapping("/account")
    public ResponseEntity<AccountWN8> getAccountWN8(@RequestParam long id) {
        AccountWN8 accountWN8 = accountWN8Service.getAccountWN8(id);
        return ResponseEntity.ok(accountWN8);
    }


}
