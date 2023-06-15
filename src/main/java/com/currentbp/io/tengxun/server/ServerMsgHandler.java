package com.currentbp.io.tengxun.server;

import com.currentbp.io.tengxun.bean.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author baopan
 * @createTime 2023-06-10 10:45:12
 */
public class ServerMsgHandler extends ChannelInboundHandlerAdapter {

    public ServerMsgHandler() {
        super();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("====>ServerMsgHandler.channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
//        System.out.println("====>ServerMsgHandler.channelUnregistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("====>ServerMsgHandler.channelActive");
        Channel channel = ctx.channel();
        channel.read();
        String data = channel.read().toString();
        System.out.println("Received data: " + data);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
//        System.out.println("====>ServerMsgHandler.channelInactive");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
//        System.out.println("====>ServerMsgHandler.userEventTriggered");
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
//        System.out.println("====>ServerMsgHandler.channelWritabilityChanged");
    }

    /**
     * 本方法用于读取客户端发送的信息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("========>ServerMsgHandler.channelRead,msg:"+msg);
        CustomMessage result = (CustomMessage) msg;
        // 接收并打印客户端的信息
        System.out.println("===Client said:" + result);

        // 向客户端发送消息
        String response = "";
        // 在当前场景下，发送的数据必须转换成ByteBuf数组

        ctx.write(msg);
        ctx.flush();
//        ctx.close();
    }

    /**
     * 本方法用作处理异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 信息获取完毕后操作
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
