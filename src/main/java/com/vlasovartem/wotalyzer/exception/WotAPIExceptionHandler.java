package com.vlasovartem.wotalyzer.exception;

import com.vlasovartem.wotalyzer.utils.exception.WotAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by artemvlasov on 05/12/2016.
 */
@ControllerAdvice
public class WotAPIExceptionHandler {

    @ExceptionHandler(WotAPIException.class)
    public ResponseEntity wotAPIExceptionHandler(WotAPIException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
