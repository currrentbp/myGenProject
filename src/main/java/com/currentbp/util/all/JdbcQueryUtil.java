package com.currentbp.util.all;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 原生的jdbc查询数据库
 *
 * @author baopan
 * @createTime 2020/2/10 10:32
 */
public class JdbcQueryUtil {

    private static String url = "jdbc:mysql://rr-2zeb92y8t5uu604u09o.mysql.rds.aliyuncs.com:3306/mall_trade" +
            "?useUnicode=true&amp;characterEncoding=UTF-8&autoReconnect=true&useSSL=false" +
            "&rewriteBatchedStatements=true&retrieveGeneratedKeys=true&serverTimezone=UTC";
    private static String user = "baopan";
    private static String password = "9EWxcgQA";

    public List<Map<String, String>> queryObject(List<String> fieldNames, String sql) {
        List<Map<String, String>> result = new ArrayList<>();
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接对象
            Connection conn = DriverManager.getConnection(url, user, password);
            // 3.获取执行SQL语句
            Statement stat = conn.createStatement();
            // 4.调用执行者对象方法,执行SQL语句获取结果集
            // 返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
            ResultSet rs = stat.executeQuery(sql);
            // System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@18cef0a
            // 5.处理结果集
            // ResultSet接口的方法 boolean next() 有结果集true,没有结果集返回false
            while (rs.next()) {
                // 获取每列的数据,使用的是ResultSet接口的方法getXXX
                Map<String, String> temp = new HashMap<>();
                for (String fieldName : fieldNames) {
                    String value = rs.getString(fieldName);
                    temp.put(fieldName, value);
                }
                result.add(temp);
            }
            // 6.关闭资源
            rs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            StringUtil.printObject("====>" + e.getMessage());
        }
        return result;
    }

    //========      test function         ===============//
    @Test
    public void t1() {
        String sql = "select * from mall_item limit 10";
        List<Map<String, String>> maps = queryObject(Lists.newArrayList("id", "name"), sql);
        StringUtil.printObject(maps);
    }

    @Test
    public void t2(){
        String sql = "select * from mall_item limit 10";
        List<Map<String, String>> maps = queryObject(Lists.newArrayList("id", "name","code"), sql);
        ExcelUtil.setSource2Excel2("mallItem",maps);
    }
}
