package com.vlasovartem.wotalyzer.service.comparator.impl;

import com.vlasovartem.wotalyzer.entity.AccountWN8CompareData;
import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;
import com.vlasovartem.wotalyzer.service.comparator.AccountComparatorService;
import com.vlasovartem.wotalyzer.service.wn8.AccountWN8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 10/12/2016.
 */
@Service
public class AccountComparatorServiceImpl implements AccountComparatorService {

    private AccountWN8Service accountWN8Service;

    @Autowired
    public AccountComparatorServiceImpl(AccountWN8Service accountWN8Service) {
        this.accountWN8Service = accountWN8Service;
    }

    @Override
    public List<AccountWN8CompareData> compareUsersWN8(List<Long> accountIds) {
        List<AccountWN8CompareData> compareData = accountIds
                .stream()
                .map(accountWN8Service::getAccountWN8)
                .sorted(Comparator.comparingInt(AccountWN8::getWn8))
                .map(AccountWN8CompareData::new)
                .collect(Collectors.toList());
        for (int i = 0; i < compareData.size(); i++)
            compareData.get(i).setCompareRank(i + 1);
        return compareData;
    }
}
