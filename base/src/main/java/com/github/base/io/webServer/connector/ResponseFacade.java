package com.github.base.io.webServer.connector;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Response的包装类
 */
public class ResponseFacade implements ServletResponse {

    private ServletResponse response = null;

    public ResponseFacade(ServletResponse response) {
        this.response = response;
    }

    @Override
    public String getCharacterEncoding() {
        return response.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
        return response.getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return response.getOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return response.getWriter();
    }

    @Override
    public void setCharacterEncoding(String s) {
        response.setCharacterEncoding(s);
    }

    @Override
    public void setContentLength(int i) {
        response.setContentLength(i);
    }

    @Override
    public void setContentLengthLong(long l) {
        response.setContentLengthLong(l);
    }

    @Override
    public void setContentType(String s) {
        response.setContentType(s);
    }

    @Override
    public void setBufferSize(int i) {
        response.setBufferSize(i);
    }

    @Override
    public int getBufferSize() {
        return response.getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
        response.flushBuffer();
    }

    @Override
    public void resetBuffer() {
        response.resetBuffer();
    }

    @Override
    public boolean isCommitted() {
        return response.isCommitted();
    }

    @Override
    public void reset() {
        response.reset();
    }

    @Override
    public void setLocale(Locale locale) {
        response.setLocale(locale);
    }

    @Override
    public Locale getLocale() {
        return response.getLocale();
    }
}
