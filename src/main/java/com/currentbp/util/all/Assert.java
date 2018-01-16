package com.currentbp.util.all;

import com.currentbp.entry.BusinessException;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * 自定义断言
 *
 * @author current_bp
 * @createTime 20171203
 */
public abstract class Assert {
    /**
     * 断言为真
     *
     * @param expression 断言结果
     * @param message    错误信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }

    /**
     * 断言不为空
     *
     * @param object  断言对象
     * @param message 错误信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
    }

    /**
     * 断言有长度
     *
     * @param text    文本
     * @param message 错误信息
     */
    public static void hasLength(String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new BusinessException(message);
        }
    }

    /**
     * 断言有内容
     *
     * @param text    文本
     * @param message 错误信息
     */
    public static void hasText(String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new BusinessException(message);
        }
    }

    /**
     * 断言数组部位空或者空对象
     *
     * @param array   数组
     * @param message 错误信息
     */
    public static void notEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new BusinessException(message);
        }
    }

    /**
     * 断言不是空集合
     *
     * @param collection 集合
     * @param message    错误信息
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new BusinessException(message);
        }
    }
}
