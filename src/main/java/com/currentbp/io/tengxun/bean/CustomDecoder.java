package com.currentbp.io.tengxun.bean;

import com.currentbp.util.all.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author baopan
 * @createTime 2023-06-10 18:25:04
 */
public class CustomDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 读取消息类型字段，假设类型长度为2个字节
        int messageType = in.readInt();

        // 读取消息长度字段，假设长度为4个字节
        int messageBodyLength = in.readInt();
        System.out.println("CustomDecoder,length:" + messageBodyLength);

        // 读取消息体，注意要减去消息类型和长度字段所占用的字节数
//        ByteBuf messageBody = in.readBytes(messageBodyLength - 6);
//        ByteBuf messageBody = in.readBytes(messageBodyLength);

        ByteBuf buf = in.readBytes(messageBodyLength);
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        System.out.println("===>decode:req:");
        StringUtil.printObject(req);

        // 构造 CustomMessage 对象并输出到 out 中
        out.add(new CustomMessage(messageType, req));
    }
}
