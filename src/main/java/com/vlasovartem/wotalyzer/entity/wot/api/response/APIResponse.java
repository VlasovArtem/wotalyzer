package com.vlasovartem.wotalyzer.entity.wot.api.response;

import java.util.Map;
import java.util.Optional;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class APIResponse<T> {

    private String status;
    private Map<String, Integer> meta;
    private T data;

    public Optional<T> getContent() {
        return Optional.ofNullable(data);
    }

    public String getStatus() {
        return status;
    }

    public Map<String, Integer> getMeta() {
        return meta;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMeta(Map<String, Integer> meta) {
        this.meta = meta;
    }

    public void setData(T data) {
        this.data = data;
    }
}
