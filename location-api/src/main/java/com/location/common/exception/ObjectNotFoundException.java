package com.location.common.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final String ERROR_MESSAGE = "ERROR: %s not found! PARAMETERS: [%s].";

    public ObjectNotFoundException(String className, String params) {
        super(String.format(ERROR_MESSAGE, className, params));
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
