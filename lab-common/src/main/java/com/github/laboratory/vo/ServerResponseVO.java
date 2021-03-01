package com.github.laboratory.vo;

import com.github.laboratory.enums.ResponseCodeEnum;
import com.github.laboratory.exception.ServerException;

import java.io.Serializable;

public class ServerResponseVO<T> implements Serializable {

    private static final long serialVersionUID = 8077009452846026853L;

    private Integer code;       //状态码

    private String message;         //描述信息

    private T data;             //返回的数据信息

    private ServerResponseVO() {
    }

    private ServerResponseVO(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    private ServerResponseVO(ResponseCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    private ServerResponseVO(ResponseCodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.data = data;
    }

    /**
     * 返回成功信息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponseVO success(T data) {
        return new ServerResponseVO<>(ResponseCodeEnum.SUCCESS, data);
    }

    /**
     * 返回成功信息
     *
     * @param codeEnum
     * @return
     */
    public static ServerResponseVO success(ResponseCodeEnum codeEnum) {
        return new ServerResponseVO(codeEnum);
    }

    /**
     * 返回成功并且附加返回信息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponseVO success(ResponseCodeEnum codeEnum, T data) {
        return new ServerResponseVO<>(codeEnum, data);
    }

    /**
     * 返回失败信息
     *
     * @param msg
     * @return
     */
    public static ServerResponseVO error(String msg) {
        return new ServerResponseVO(ResponseCodeEnum.ERROR.getCode(), msg);
    }

    /**
     * 返回失败信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ServerResponseVO error(int code, String msg) {
        return new ServerResponseVO(code, msg);
    }

    /**
     * 返回失败信息
     *
     * @param codeEnum
     * @return
     */
    public static ServerResponseVO error(ResponseCodeEnum codeEnum) {
        return new ServerResponseVO(codeEnum);
    }

    /**
     * 返回失败信息
     *
     * @param serverException
     * @return
     */
    public static ServerResponseVO error(ServerException serverException) {
        return new ServerResponseVO(serverException.getCode(), serverException.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
