package com.currentbp.io.nio.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baopan
 * @createTime 6/8/2023 8:28 AM
 */
public class ClientMsgHandler extends ChannelInboundHandlerAdapter {
    AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * 本方法用于处理异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
//        System.out.println("===>exception=====");
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 本方法用于向服务端发送信息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("===>ClientMsgHandler.channelActive======================");
        //todo 出现粘包问题了
        for (int i = 0; i < 100; i++) {
            String msg = "====sendValue==>" + atomicInteger.getAndIncrement();
            ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
            encoded.writeBytes(msg.getBytes());
            ctx.write(encoded);
            ctx.flush();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ClientMsgHandler.channelRead" + msg);

    }
}
