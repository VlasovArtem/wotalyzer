package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlasovartem.wotalyzer.entity.wot.api.MainEntity;

/**
 * Created by artemvlasov on 07/09/16.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Players extends MainEntity {

    @JsonProperty("account_id")
    private long id;
    private String nickname;

}
