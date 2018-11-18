package com.vlasovartem.wotalyzer.exception.wot.api;

import com.vlasovartem.wotalyzer.entity.wot.api.WotApiError;
import org.springframework.http.HttpStatus;

/**
 * Created by artemvlasov on 24/12/2016.
 */
public class WotAPIValidationException extends RuntimeException {

    private WotApiError error;

    private WotAPIValidationException() {
        error = new WotApiError();
    }

    public WotAPIValidationException(String message) {
        this();
        error.getError().setMessage(message);
    }

    public WotAPIValidationException(String message, HttpStatus status) {
        this();
        error.getError().setMessage(message);
        error.getError().setCode(status.value());
    }

    public WotAPIValidationException(WotApiError error) {
        this.error = error;
    }
}
