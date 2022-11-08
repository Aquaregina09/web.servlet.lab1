package com.webshoppe.ecommerce.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 4482527458772936691L;

    public ServiceException(String message) {
        super(message);
    }

    public static ServiceException instance(String message) {
        return new ServiceException(message);
    }
}
