package com.webshoppe.ecommerce.exception;

public class DataAccessException extends RuntimeException {
    private static final long serialVersionUID = 4482527458772936691L;

    public DataAccessException(String message) {
        super(message);
    }

    public static DataAccessException instance(String message) {
        return new DataAccessException(message);
    }
}
