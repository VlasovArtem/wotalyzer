package com.vlasovartem.wotalyzer.exception.handler;

import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by artemvlasov on 24/12/2016.
 */
@ControllerAdvice
public class WotAPIValidationExceptionHandler {

    @ExceptionHandler(WotAPIValidationException.class)
    public ResponseEntity handleException(WotAPIValidationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
