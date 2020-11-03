package com.srx.discussion.entity.DTO;

public class ErrorMessage {
    private String errorMessage;
    private String errorCode;

    public ErrorMessage(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ErrorMessage() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "errorMessage{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
