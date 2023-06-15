package com.currentbp.io.tengxun.bean;

import com.currentbp.util.all.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author baopan
 * @createTime 2023-06-10 18:24:13
 */
public class CustomEncoder extends MessageToByteEncoder<CustomMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, CustomMessage msg, ByteBuf out) throws Exception {
        // 写入消息类型字段，假设类型长度为2个字节
        int messageType = msg.getMessageType();
//        System.out.println("messageType:" + messageType);


        byte[] messageBody = msg.getMessageBody();
        // 写入消息长度字段，假设长度为4个字节
        int length = messageBody.length;
        System.out.println("length:" + length);


        // 写入消息体
        System.out.println("===>encode:body:");
        StringUtil.printObject(messageBody);

        out.writeInt(messageType);
        out.writeInt(length);
        out.writeBytes(messageBody);
    }
}
