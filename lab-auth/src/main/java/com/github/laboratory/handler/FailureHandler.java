package com.github.laboratory.handler;

import cn.hutool.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 登录失败Handler
 * Created At 2021/4/5
 */
@Configuration
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code", 500);
        jsonObject.set("message", "登录失败，账号或密码错误");
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        httpServletResponse.getWriter().write(jsonObject.toString());
    }
}
