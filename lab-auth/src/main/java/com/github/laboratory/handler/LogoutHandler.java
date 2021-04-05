package com.github.laboratory.handler;

import cn.hutool.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 退出登录Handler
 * Created At 2021/4/5
 */
@Configuration
public class LogoutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code", 200);
        jsonObject.set("message", "注销成功");
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        httpServletResponse.getWriter().write(jsonObject.toString());
    }
}
