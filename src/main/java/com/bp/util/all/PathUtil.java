package com.bp.util.all;

import com.bp.staticValue.StaticProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * 关于路进的类util
 *
 * @author current_bp
 * @createTime 20171030
 */
public class PathUtil {
    private final static Logger logger = LoggerFactory.getLogger(PathUtil.class);

    /**
     * 获取当前项目的mvn项目的资源路径
     *
     * @return 路径
     */
    public static String getMvnLocalResourcePath() {
        String allPath = new PathUtil().getClass().getClassLoader().getResource("//").getPath();
        String pre = allPath.substring(0, allPath.indexOf("target"));
        return pre + "src/main/resources/";
    }


    /**
     * 获取url的最后文件名
     *
     * @param url url
     * @return 文件名
     */
    public static String getTailFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + StaticProperties.ONE_INT);
    }


}
