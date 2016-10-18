package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;

/**
 * Created by artemvlasov on 07/09/16.
 */
public class Players extends MainEntity {

    private String nickname;

    @Override
    @JsonProperty("account_id")
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
