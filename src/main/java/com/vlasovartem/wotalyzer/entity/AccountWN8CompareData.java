package com.vlasovartem.wotalyzer.entity;

import com.vlasovartem.wotalyzer.entity.wn8.AccountWN8;

/**
 * Created by artemvlasov on 10/12/2016.
 */
public class AccountWN8CompareData {

    private int compareRank;
    private AccountWN8 accountWN8;

    public AccountWN8CompareData(AccountWN8 accountWN8) {
        this.accountWN8 = accountWN8;
    }

    public int getCompareRank() {
        return compareRank;
    }

    public void setCompareRank(int compareRank) {
        this.compareRank = compareRank;
    }

    public AccountWN8 getAccountWN8() {
        return accountWN8;
    }

    public void setAccountWN8(AccountWN8 accountWN8) {
        this.accountWN8 = accountWN8;
    }
}
