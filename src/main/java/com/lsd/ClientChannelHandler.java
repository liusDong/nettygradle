package com.lsd;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import java.util.UUID;

public class ClientChannelHandler extends SimpleChannelInboundHandler<String> {
    Logger logger = Logger.getLogger(ClientChannelHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info(msg);
    }
}
