package com.vlasovartem.wotalyzer.entity.wot.api.response;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by artemvlasov on 16/11/2016.
 */
public class NullAPIResponse extends AbstractAPIResponse {

    private static NullAPIResponse nullAPIResponse;

    private NullAPIResponse() {
    }

    public static NullAPIResponse getNullResponse() {
        if (Objects.isNull(nullAPIResponse)) {
            nullAPIResponse = new NullAPIResponse();
        }
        return nullAPIResponse;
    }

    @Override
    public Optional getContent() {
        return Optional.empty();
    }
}
