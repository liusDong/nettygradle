package com.lsd;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestClient {

    public static void main(String[] args) {

        IntStream.range(1,500).forEach(e->{
            TestClient testClient = new TestClient();
            testClient.run();
        });

    }


    private void run(){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ClientChannelInit());
            Channel ch = bootstrap.connect("47.103.115.67", 8899).sync().channel();

            while (true){
                String msg = UUID.randomUUID().toString()+ "      "+LocalDateTime.now();
                ch.writeAndFlush(msg);
                System.out.println(msg);
                TimeUnit.SECONDS.sleep(2);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
