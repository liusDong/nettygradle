package com.lsd;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import org.apache.log4j.Logger;

public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {

    private static Logger logger = Logger.getLogger(ServerChannelHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info(msg);
        ctx.channel().writeAndFlush(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress()+" is in active");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress()+" is in out of active");

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress()+" is in register");
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info(ctx.channel().remoteAddress()+" is in out of register");

    }
}
