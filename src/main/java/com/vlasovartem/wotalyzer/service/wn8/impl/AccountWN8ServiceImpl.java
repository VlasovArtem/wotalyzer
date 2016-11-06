package com.vlasovartem.wotalyzer.service.wn8.impl;

import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;
import com.vlasovartem.wotalyzer.entity.wn8.RationData;
import com.vlasovartem.wotalyzer.repository.wn8.AccountWN8Repository;
import com.vlasovartem.wotalyzer.service.wn8.AccountWN8Service;
import com.vlasovartem.wotalyzer.service.wn8.RatioDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by artemvlasov on 02/11/2016.
 */
@Service
public class AccountWN8ServiceImpl implements AccountWN8Service {

    private final RatioDataService dataService;
    private final AccountWN8Repository wn8Repository;


    @Autowired
    public AccountWN8ServiceImpl(RatioDataService dataService, AccountWN8Repository wn8Repository) {
        this.dataService = dataService;
        this.wn8Repository = wn8Repository;
    }

    @Override
    public AccountWN8 getAccountWN8(long accountId) {
        AccountWN8 accountWN8 = wn8Repository.findOne(accountId);
        if (Objects.nonNull(accountWN8)) {
            LocalDateTime modifiedDate = accountWN8.getModifiedDate();
            if (modifiedDate.toLocalDate().isEqual(LocalDate.now())) {
                return accountWN8;
            }
        } else {
            accountWN8 = new AccountWN8(accountId);
        }
        accountWN8.setWn8(calculateWN8(accountId));
        wn8Repository.save(accountWN8);
        return accountWN8;
    }

    private int calculateWN8(long accountId) {
        RationData accountRatioDataZeroPoint = dataService.getAccountRatioDataZeroPoint(accountId);
        return (int)
                (980 * accountRatioDataZeroPoint.getDamage() +
                210 * accountRatioDataZeroPoint.getDamage() * accountRatioDataZeroPoint.getFrag() +
                155 * accountRatioDataZeroPoint.getFrag() * accountRatioDataZeroPoint.getSpot() +
                75 * accountRatioDataZeroPoint.getDef() * accountRatioDataZeroPoint.getFrag() +
                145 * Double.min(1.8, accountRatioDataZeroPoint.getWinRate()));
    }
}
