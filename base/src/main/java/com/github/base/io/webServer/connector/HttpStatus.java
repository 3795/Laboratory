package com.github.base.io.webServer.connector;

public enum HttpStatus {
    SC_OK(200, "OK"),
    SC_NOT_FOUND(404, "FIle Not Found")
    ;
    private int statusCode;

    private String reason;

    HttpStatus(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
