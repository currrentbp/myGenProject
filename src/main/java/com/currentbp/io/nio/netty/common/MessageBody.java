package com.currentbp.io.nio.netty.common;

/**
 * @author baopan
 * @createTime 2023-06-10 19:53:05
 */
public class MessageBody {
    private String id;
    private Integer type;
    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
