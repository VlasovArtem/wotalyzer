package com.vlasovartem.wotalyzer.entity.wot.api.global_map;

import com.vlasovartem.wotalyzer.entity.wot.api.global_map.components.EventRatingAbstract;

/**
 * Created by artemvlasov on 15/10/2016.
 */
public class EventAccountRatingNeighbor extends EventRatingAbstract {

    /* Player account ID */
    private int accountId;
    /* Link to Front */
    private String url;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
