package com.vlasovartem.wotalyzer.entity.wot.api.response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 02/11/2016.
 */
public class APIResponseMap<T> extends AbstractAPIResponse<Map<String, T>> {

    @Override
    public List<T> getContent() {
        return getData().values().stream().collect(Collectors.toList());
    }
}
