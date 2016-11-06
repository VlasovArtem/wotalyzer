package com.vlasovartem.wotalyzer.entity.wot.api.response;

import java.util.List;

/**
 * Created by artemvlasov on 02/11/2016.
 */
public class APIResponseList<T> extends AbstractAPIResponse<List<T>> {

    @Override
    public List<T> getContent() {
        return getData();
    }
}
