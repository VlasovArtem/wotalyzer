package com.vlasovartem.wotalyzer.entity.wot.api;

/**
 * Created by artemvlasov on 16/10/2016.
 */
public abstract class MainEntity extends Entity {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
