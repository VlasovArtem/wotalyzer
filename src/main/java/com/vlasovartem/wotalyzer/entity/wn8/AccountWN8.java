package com.vlasovartem.wotalyzer.entity.wn8;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by artemvlasov on 01/11/2016.
 */
@Document(collection = "accountWN8")
public class AccountWN8 {

    @Id
    private long accountId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int wn8;

    public AccountWN8() {
        modifiedDate = createdDate = LocalDateTime.now();
    }

    public AccountWN8(long accountId) {
        this();
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public int getWn8() {
        return wn8;
    }

    public void setWn8(int wn8) {
        if (wn8 != this.wn8) {
            this.wn8 = wn8;
            modifiedDate = LocalDateTime.now();
        }
    }
}
