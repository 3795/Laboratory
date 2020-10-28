package com.github.base.io.webServer.processor;

import io.webServer.connector.*;

import javax.servlet.Servlet;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态请求的处理器
 */
public class ServletProcess {

    /**
     * 设置Servlet加载器，设置其加载Servlet时的查找路径
     *
     * @return
     * @throws MalformedURLException
     */
    URLClassLoader getServletLoader() throws MalformedURLException {
        File servletPath = new File(ConnectorUtil.WEB_ROOT + "/servlet");
        URL webRootUrl = servletPath.toURI().toURL();
        return new URLClassLoader(new URL[]{webRootUrl});
    }

    /**
     * 根据请求得到对应的Servlet
     *
     * @param loader
     * @param request
     * @return
     * @throws Exception
     */
    Servlet getServlet(URLClassLoader loader, Request request) throws Exception {
        String uri = request.getRequestURI();       // /servlet/TimeServlet
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);       // TimeServlet

        Class servletClass = loader.loadClass(servletName);     // 在对应的路径下根据ServletName找到对应的Servlet类
        return (Servlet) servletClass.newInstance();        // 使用反射创建对象
    }

    public void process(Request request, Response response) {
        try {
            URLClassLoader loader = getServletLoader();
            Servlet servlet = getServlet(loader, request);
            RequestFacade requestFacade = new RequestFacade(request);
            ResponseFacade responseFacade = new ResponseFacade(response);
            servlet.service(requestFacade, responseFacade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    D:\Develop\Java\Research\src\io\webServer\webroot\servlet\TimeServlet.java
}
