package com.github.base.io.webServer.connector;

import java.io.File;

public class ConnectorUtil {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "src/io/webServer/webroot";

    public static final String PROTOCOL = "HTTP/1.1";

    public static final String CARRIAGE = "\r";

    public static final String NEWLINE = "\n";

    public static final String SPACE = " ";

    public static String renderStatus(HttpStatus status) {
        String sb = PROTOCOL +
                SPACE +
                status.getStatusCode() +
                SPACE +
                status.getReason() +
                CARRIAGE + NEWLINE +
                CARRIAGE + NEWLINE;
        return sb;
    }
}
