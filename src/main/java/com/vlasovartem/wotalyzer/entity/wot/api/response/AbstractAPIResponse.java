package com.vlasovartem.wotalyzer.entity.wot.api.response;

import java.util.Map;

/**
 * Created by artemvlasov on 14/01/16.
 */
public abstract class AbstractAPIResponse<T> {

    private String status;
    private Map<String, Integer> meta;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Integer> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Integer> meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public abstract Object getContent();

}
