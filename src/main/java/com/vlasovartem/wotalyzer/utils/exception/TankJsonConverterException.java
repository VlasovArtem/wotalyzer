package com.vlasovartem.wotalyzer.utils.exception;

/**
 * Created by artemvlasov on 14/01/16.
 */
public class TankJsonConverterException extends RuntimeException {
    public TankJsonConverterException() {
    }

    public TankJsonConverterException(String message) {
        super(message);
    }

    public TankJsonConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public TankJsonConverterException(Throwable cause) {
        super(cause);
    }

    public TankJsonConverterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
