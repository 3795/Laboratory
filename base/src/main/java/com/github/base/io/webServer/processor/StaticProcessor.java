package com.github.base.io.webServer.processor;


import com.github.base.io.webServer.connector.Request;
import com.github.base.io.webServer.connector.Response;

/**
 * 静态文件的处理器
 */
public class StaticProcessor {

    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
