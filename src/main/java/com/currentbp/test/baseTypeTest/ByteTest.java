package com.currentbp.test.baseTypeTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * byte 测试
 *
 * @author current_bp
 * @createTime 20170623
 */
public class ByteTest {
    private static Logger logger = LoggerFactory.getLogger(ByteTest.class);


    @Test
    public void byte1() {
        byte[] bytes = new byte[1 << 30];//1<<31 会报错：NegativeArraySizeException
        logger.info("size;" + bytes.length);
        System.out.println("1987".charAt(3));
    }

    @Test
    public void t1() {
        byte[] x = new byte[]{8, 49, 18, -10, 1, 8, -39, -115, 5, 16, -109, -18, 5, 26, -23, 1, 8, -60, 3, 18, 12, -27,
                -122, -84, -24, -121, -77, -23, -91, -70, -27, -83, -112, 24, 1, 34, 94, 104, 116, 116, 112, 115, 58, 47, 47,
                115, 116, 97, 103, 105, 110, 103, 45, 99, 110, 98, 106, 50, 45, 102, 100, 115, 46, 97, 112, 105, 46, 120, 105,
                97, 111, 109, 105, 46, 110, 101, 116, 47, 97, 112, 104, 114, 111, 100, 105, 116, 101, 47, 117, 112, 108, 111, 97,
                100, 47, 49, 50, 48, 55, 49, 54, 98, 54, 51, 50, 100, 56, 48, 99, 48, 101, 51, 55, 98, 97, 53, 99, 100, 56, 97, 57,
                49, 52, 50, 52, 52, 54, 46, 112, 110, 103, 42, 94, 104, 116, 116, 112, 115, 58, 47, 47, 115, 116, 97, 103, 105, 110,
                103, 45, 99, 110, 98, 106, 50, 45, 102, 100, 115, 46, 97, 112, 105, 46, 120, 105, 97, 111, 109, 105, 46, 110, 101,
                116, 47, 97, 112, 104, 114, 111, 100, 105, 116, 101, 47, 117, 112, 108, 111, 97, 100, 47, 98, 48, 51, 99, 54, 99, 98,
                57, 97, 98, 57, 51, 56, 54, 98, 55, 54, 102, 99, 57, 97, 99, 48, 54, 50, 97, 50, 98, 51, 56, 56,
                51, 46, 122, 105, 112, 48, -46, 1, 56, -46, 1, 66, 7, 68, 73, 65, 77, 79, 78, 68, 72, 2, 80, 1, 88, -46, 1, 32, 1};
        try {
            String s = new String(x, "UTF-8");
            System.out.println(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
