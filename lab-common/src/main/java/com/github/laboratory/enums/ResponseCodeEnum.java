package com.github.laboratory.enums;

/**
 * 系统返回值枚举
 */
public enum ResponseCodeEnum {
    SUCCESS(200, "SUCCESS"),

    ERROR(500, "ERROR"),
    NOT_FOUND(404, "资源不存在"),
    UNAUTHORIZED(403, "权限不足"),
    ILLEGAL_PARAMETER(401, "参数非法"),
    BAD_REQUEST(400, "Bad Request"),

    ;
    private int code;

    private String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
