package com.location.common.exception.handler;

import java.io.Serializable;

public class StandartError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String errorMessage;
    private Long timestamp;

    public StandartError(Integer status, String errorMessage, Long timestamp) {
        super();
        this.status = status;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
