package com.company.train.exception;

public class TrainCompanyException extends RuntimeException {
    public TrainCompanyException(String message, Throwable e) {
        super(message, e);
    }
}
