package com.currentbp.util.all;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author baopan
 * @createTime 20200525
 */
public class EmailUtilTest {

    @Test
    public void test1() {
        // 收件人电子邮箱
        String to = "baopan@gaosiedu.com";

        // 发件人电子邮箱
        String from = "baopan112233@126.com";

        // 指定发送邮件的主机为 localhost
        String host = "mail.gaosiedu.com";

        EmailUtil.sendSimpleEmail(from,to,host,
                "标题",
                "内容\n内容2");
    }

}