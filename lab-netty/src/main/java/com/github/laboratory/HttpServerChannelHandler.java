package com.github.laboratory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpServerChannelHandler extends SimpleChannelInboundHandler<HttpObject> {

    private HttpRequest httpRequest;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject msg) {
        if (msg instanceof HttpRequest) {
            httpRequest = (HttpRequest) msg;
            String uri = httpRequest.uri();
            System.out.println("Uri" + uri);
        }

        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            System.out.println(buf.toString(CharsetUtil.UTF_8));

            ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().add(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            channelHandlerContext.writeAndFlush(response);
        }


    }
}
