package com.github.laboratory.exception;

import com.github.laboratory.enums.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义异常
 */
public class ServerException extends RuntimeException {

    private static final long serialVersionUID = -1658981574546119869L;

    private static Logger logger = LoggerFactory.getLogger(ServerException.class);

    private int code;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServerException(ResponseCodeEnum responseCodeEnum) {
        super(responseCodeEnum.getMessage());
        this.code = responseCodeEnum.getCode();
    }

    public ServerException(String message) {
        super(message);
        this.code = ResponseCodeEnum.ERROR.getCode();
    }

    /**
     * 自定义的异常，统一打印异常日志
     *
     * @param exDetail         异常的详细情况
     * @param responseCodeEnum 异常枚举
     */
    public ServerException(String exDetail, ResponseCodeEnum responseCodeEnum) {
        super(responseCodeEnum.getMessage());
        this.code = responseCodeEnum.getCode();
        // 打印错误日志
        logger.error(exDetail);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
