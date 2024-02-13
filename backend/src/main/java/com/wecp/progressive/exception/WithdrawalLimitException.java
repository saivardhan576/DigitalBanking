package com.wecp.progressive.exception;

public class WithdrawalLimitException extends RuntimeException {

    public WithdrawalLimitException() {
    }

    public WithdrawalLimitException(String message) {
        super(message);
    }
    
}