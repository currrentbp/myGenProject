package com.bp.util.all.encryption;

import com.bp.util.all.CheckUtil;
import org.apache.commons.codec.binary.Base64;

/**
 * @author current_bp
 * @createTime 20170523
 */
public class Bas64Util {
    /**
     * @param value
     * @return
     * @Method：解密
     */
    public static String decodeBase64(String value) {
        if (CheckUtil.isEmpty(value)) {
            return null;
        }
        return new String(Base64.decodeBase64(value.getBytes()));
    }

    /**
     * @param value
     * @return
     * @Method：加密
     */
    public static String encodeBase64(String value) {
        if (CheckUtil.isEmpty(value)) {
            return null;
        }
        return new String(Base64.encodeBase64(value.getBytes()));
    }
}
