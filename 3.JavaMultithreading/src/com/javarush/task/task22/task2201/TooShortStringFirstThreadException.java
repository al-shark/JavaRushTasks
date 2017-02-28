package com.javarush.task.task22.task2201;

public class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException() {
        super();
    }

    public TooShortStringFirstThreadException(String message) {
        super(message);
    }

    public TooShortStringFirstThreadException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooShortStringFirstThreadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TooShortStringFirstThreadException(Throwable cause) {
        super(cause);
    }
}
