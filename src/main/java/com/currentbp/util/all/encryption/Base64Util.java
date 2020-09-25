package com.currentbp.util.all.encryption;

import com.currentbp.util.all.CheckUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author current_bp
 * @createTime 20170523
 */
public class Base64Util {
    /**
     * 解密
     *
     * @param value
     * @return
     * @Method：解密
     */
    public static String decodeBase64(String value) {
        if (CheckUtil.isEmpty(value)) {
            return null;
        }
        String result = null;
        try {
            //此处默认数据来源是utf-8的
            result = new String(Base64.decodeBase64(value.getBytes("utf-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**加密
     * @param value
     * @return
     * @Method：加密
     */
    public static String encodeBase64(String value) {
        if (CheckUtil.isEmpty(value)) {
            return null;
        }
        String result = null;
        try {
            //此处默认数据来源是utf-8的
            result = new String(Base64.encodeBase64(value.getBytes("utf-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
