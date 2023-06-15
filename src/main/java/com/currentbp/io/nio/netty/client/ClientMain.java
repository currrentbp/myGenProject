package com.currentbp.io.nio.netty.client;

import com.currentbp.io.nio.netty.common.CustomDecoder;
import com.currentbp.io.nio.netty.common.CustomEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author baopan
 * @createTime 6/8/2023 7:52 AM
 */
public class ClientMain {
    public static String host = "127.0.0.1";
    public static int port = 8088;

    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            // 客户端启动类程序
            Bootstrap bootstrap = new Bootstrap();
            //EventLoop的组
            bootstrap.group(worker);
            //用于构造socketchannel工厂
            bootstrap.channel(NioSocketChannel.class);
            //参数：Socket的标准参数（key，value）:保持呼吸
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new LoggingHandler(LogLevel.DEBUG));
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("decoder", new CustomDecoder());
                    ch.pipeline().addLast("encoder", new CustomEncoder());
                    ch.pipeline().addLast(new ClientMsgHandler());
//                    ch.pipeline().addLast( new CustomEncoder(),new CustomDecoder(),new ClientMsgHandler());
                }
            });

            /** 开启客户端监听，连接到远程节点，阻塞等待直到连接完成*/
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            /**阻塞等待数据，直到channel关闭(客户端关闭)*/
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }
}
