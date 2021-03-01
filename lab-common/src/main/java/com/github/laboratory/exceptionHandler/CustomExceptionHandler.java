package com.github.laboratory.exceptionHandler;

import com.github.laboratory.enums.ResponseCodeEnum;
import com.github.laboratory.exception.ServerException;
import com.github.laboratory.vo.ServerResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author qihao
 * @description 自定义的异常处理器
 * @date 2021/2/26 17:40
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 捕获@Valid校验不通过的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServerResponseVO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("MethodArgumentNotValidException -> message = {}", e.getMessage());
        BindingResult ex = e.getBindingResult();
        return ServerResponseVO.error(ResponseCodeEnum.ILLEGAL_PARAMETER.getCode(),
                ex.getFieldError().getDefaultMessage());
    }

    /**
     * 捕获自定义的异常
     *
     * @param serverException
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public ServerResponseVO handleServerException(ServerException serverException) {
        log.warn("ServerException -> code = {}, message = {}", serverException.getCode(),
                serverException.getMessage());
        return ServerResponseVO.error(serverException);
    }

    /**
     * 捕获Exception异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ServerResponseVO handleException(Exception e) {
        log.error("Exception -> message = {}", e.getMessage());
        return ServerResponseVO.error(ResponseCodeEnum.ERROR);
    }


}
