package com.currentbp.io.tengxun.bean;

import java.util.Arrays;

/**
 * @author baopan
 * @createTime 2023-06-10 18:25:43
 */
public class CustomMessage {
    //消息类型：1：
    private int messageType;
    //MessageBody的字符串结构
    private byte[] messageBody;

    public CustomMessage(int messageType, byte[] messageBody) {
        this.messageType = messageType;
        this.messageBody = messageBody;
    }

    public int getMessageType() {
        return messageType;
    }

    public byte[] getMessageBody() {
        return messageBody;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public void setMessageBody(byte[] messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "messageType=" + messageType +
                ", messageBody=" + Arrays.toString(messageBody) +
                '}';
    }
}
