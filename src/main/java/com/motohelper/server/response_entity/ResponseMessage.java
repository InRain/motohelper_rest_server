package com.motohelper.server.response_entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessage {
    private String message;
    private String description;

    public static final String EXISTS = "EXISTS";
    public static final String PASSWORD_IS_NULL = "PASSWORD_IS_NULL";

    public ResponseMessage() {
    }


    public ResponseMessage(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
