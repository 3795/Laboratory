package com.github.laboratory.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 登录成功Handler
 * Created At 2021/4/5
 */
@Configuration
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        JSONObject.toJSONString(authentication, SerializerFeature.DisableCircularReferenceDetect);
    }
}
