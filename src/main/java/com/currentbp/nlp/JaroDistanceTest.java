package com.currentbp.nlp;

import com.currentbp.util.all.StreamUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220815
 */
public class JaroDistanceTest {
    @Test
    public void t1() {
        String reviewName = "baopan";
        String newsName = "baopan";
        double dis = StringUtils.getJaroWinklerDistance(reviewName.toLowerCase(), newsName.toLowerCase());
        System.out.println(dis);
    }

    @Test
    public void t2() throws Exception {
        List<String> listByAbstrackPath = StreamUtil.getListByAbstrackPath("C:\\Users\\baopan\\Desktop\\gameName.txt");
        listByAbstrackPath.forEach(line -> {
            String[] kv = line.split(":");
            String source = kv[0];
            String others = kv[1];
            String[] splits = others.split(",");
            for (String split : splits) {
                double dis = StringUtils.getJaroWinklerDistance(source.toLowerCase(), split.toLowerCase());
                System.out.println("source:" + source + ":value:" + split + ":distance:" + dis);
            }
        });
    }
}
