package com.example.integerlist;

public class wroneIndexException extends RuntimeException {
    public wroneIndexException() {
    }

    public wroneIndexException(String message) {
        super(message);
    }

    public wroneIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public wroneIndexException(Throwable cause) {
        super(cause);
    }

    public wroneIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
