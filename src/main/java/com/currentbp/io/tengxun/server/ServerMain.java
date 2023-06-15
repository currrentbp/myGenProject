package com.currentbp.io.tengxun.server;


import com.currentbp.io.tengxun.bean.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author baopan
 * @createTime 6/8/2023 7:53 AM
 */
public class ServerMain {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // netty服务器启动类的创建, 辅助工具类，用于服务器通道的一系列配置
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            /**
             * 使用了多少线程以及如何将它们映射到创建的通道取决于EventLoopGroup实现，甚至可以通过构造函数进行配置。
             * 设置循环线程组，前者用于处理客户端连接事件，后者用于处理网络IO(server使用两个参数这个)
             */
            serverBootstrap.group(bossGroup, workerGroup)           //绑定两个线程组
                    // 用于构造socketchannel工厂
                    .channel(NioServerSocketChannel.class)   //指定NIO的模式
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<SocketChannel>() {  // 子处理器，用于处理workerGroup
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("decoder", new CustomDecoder());
                            socketChannel.pipeline().addLast("encoder", new CustomEncoder());
                            socketChannel.pipeline().addLast(new ServerMsgHandler());
//                            socketChannel.pipeline().addLast( new CustomEncoder(),new CustomDecoder(),new ServerMsgHandler());
                        }
                    });

            // 启动server，绑定端口，开始接收进来的连接，设置8088为启动的端口号
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            // 监听关闭的channel，等待服务器 socket关闭
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
