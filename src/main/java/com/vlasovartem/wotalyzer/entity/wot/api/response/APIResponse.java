package com.vlasovartem.wotalyzer.entity.wot.api.response;

/**
 * Created by artemvlasov on 02/11/2016.
 */
public class APIResponse<T> extends AbstractAPIResponse<T> {

    @Override
    public T getContent() {
        return getData();
    }
}
