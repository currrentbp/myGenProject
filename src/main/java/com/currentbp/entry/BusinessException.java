package com.currentbp.entry;

/**
 * 业务异常
 *
 * @author current_bp
 * @createTime 20180115
 */
public class BusinessException extends RuntimeException {

    private String code;
    private String msg;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        this.msg = msg;
    }

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(BusinessExceptionCode businessExceptionCode) {
        this.code = businessExceptionCode.getCode();
        this.msg = businessExceptionCode.getMsg();
    }


}
