package com.github.laboratory;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 处理Http消息的编码
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        // 添加自定义的ChannelHandler
        pipeline.addLast("httpServerHandler", new HttpServerChannelHandler());
    }
}
