package com.vlasovartem.wotalyzer.entity.wot.api.account;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by artemvlasov on 07/09/16.
 */
@JsonAutoDetect
public class PlayersSearch {

    @JsonProperty("account_id")
    private long id;
    private String nickname;

}
