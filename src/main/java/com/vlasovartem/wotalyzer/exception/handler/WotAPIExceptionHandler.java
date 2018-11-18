package com.vlasovartem.wotalyzer.exception.handler;

import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by artemvlasov on 01/11/2016.
 */
@ControllerAdvice
public class WotAPIExceptionHandler {

    @ExceptionHandler(WotAPIException.class)
    public ResponseEntity handleException(WotAPIException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
