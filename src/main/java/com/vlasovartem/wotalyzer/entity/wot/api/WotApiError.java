package com.vlasovartem.wotalyzer.entity.wot.api;

/**
 * Created by artemvlasov on 24/12/2016.
 */
public class WotApiError {

    private String status;
    private ErrorData error;

    public WotApiError() {
        status = "error";
        error = new ErrorData();
    }

    public class ErrorData {
        private String field;
        private String message;
        private int code;
        private String value;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("WOT API Error, status - %d, message - %s, error field - %s, incorrect value - %s", code, message, field, value);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorData getError() {
        return error;
    }

    public void setError(ErrorData error) {
        this.error = error;
    }

}
