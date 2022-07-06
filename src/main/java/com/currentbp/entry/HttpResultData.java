package com.currentbp.entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * http请求结果
 *
 * @author baopan
 * @createTime 20180531
 */
public class HttpResultData implements Serializable {
    private static final long serialVersionUID = 2217166602613850605L;
    private static Logger logger = LoggerFactory.getLogger(HttpResultData.class);

    public static final int OK = 1;
    public static final int ERROR = 0;

    public static final int IS_OK = 200; //正常返回请求
    public static final int IS_GET_HEAD = 206;//获取请求头时，返回的状态
    public static final int IS_CUSTOM_ERROR = 400;//客户端报错状态开始点
    public static final int IS_SERVER_ERROR = 500;//服务端报错状态开始点
    public static final int IS_OTHER_ERROR = -1;//其他类型错误

    private int status = OK; //业务状态 默认正常

    private Integer code; //请求状态代码

    private String body;//返回报文

    public HttpResultData() {
        super();
    }

    public HttpResultData(int status, Integer code, String body) {
        super();
        this.status = status;
        this.code = code;
        this.body = body;
    }

    public int getStatus() {
        if (this.code >= IS_OK && this.code < 300) {
            this.status = OK;
        } else {
            this.status = ERROR;
        }
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public HttpResultData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getBody() {
        return body;
    }

    public HttpResultData setBody(String body) {
        this.body = body;
        return this;
    }

    public boolean isSuccess() {
        return getStatus() == 1;
    }

    public boolean isNotSuccess() {
        return getStatus() != 1;
    }

    @Override
    public String toString() {
        return "HttpResultData{" +
                "status=" + getStatus() +
                ", code=" + code +
                ", body='" + body + '\'' +
                '}';
    }
}
