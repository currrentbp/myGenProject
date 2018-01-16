package com.currentbp.entry;

/**
 * 错误码
 *
 * @author current_bp
 * @createTime 20180115
 */
public enum BusinessExceptionCode {

    SYSTEM_ERROR("E00000", "系统错误"),

    ;

    public final String code;
    public final String msg;

    BusinessExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getName(String code) {
        for (BusinessExceptionCode businessExceptionCode : BusinessExceptionCode.values()) {
            if (businessExceptionCode.code.equals(code)) {
                return businessExceptionCode.msg;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
