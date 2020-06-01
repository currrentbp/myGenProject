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
        ExcelUtil.setSource2Excel2("mallItem",maps,null);
    }

    @Test
    public void zangguadingdang(){
        String sql = "SELECT\n" +
                "mo.order_id as `order_id`,\n" +
                "institution_id,\n" +
                "mo.create_time,\n" +
                "od.name as 'spuName',\n" +
                "ms.name as 'skuName',\n" +
                "od.bar_code,\n" +
                "goo.period,\n" +
                "if(1=goo.period,'春季',if(2=goo.period,'暑假',if(3=goo.period,'秋季','寒假'))) as '学期',\n" +
                "ms.grade_id,\n" +
                "if(2=ms.grade_id,'一年级',if(3=ms.grade_id,'二年级',if(4=ms.grade_id,'三年级',if(5=ms.grade_id,'四年级',if(6=ms.grade_id,'五年级',if(7=ms.grade_id,'六年级',\n" +
                "if(62=ms.grade_id,'短线班',if(65=ms.grade_id,'初一',if(66=ms.grade_id,'初二',if(67=ms.grade_id,'初三',if(68=ms.grade_id,'高一',if(70=ms.grade_id,'高二',\n" +
                "if(71=ms.grade_id,'高三',if(73=ms.grade_id,'初四',if(74=ms.grade_id,'剑桥国际',if(75=ms.grade_id,'新概念突破版',if(76=ms.grade_id,'新概念英语',if(77=ms.grade_id,'新概念提高版',\n" +
                "if(78=ms.grade_id,'剑桥国际少儿',if(79=ms.grade_id,'小升初衔接班',if(80=ms.grade_id,'新概念青少',if(81=ms.grade_id,'小英短线班',if(82=ms.grade_id,'测试专用年级',if(83=ms.grade_id,'思高语音',\n" +
                "if(84=ms.grade_id,'幼小衔接',if(85=ms.grade_id,'一阶',if(86=ms.grade_id,'二阶',if(87=ms.grade_id,'三阶',if(88=ms.grade_id,'西方节日',if(89=ms.grade_id,'朗文励步',\n" +
                "if(90=ms.grade_id,'初中短线班',if(91=ms.grade_id,'高中短线班',''))\n" +
                "))))))\n" +
                "))))))\n" +
                "))))))\n" +
                ")))))\n" +
                "))))))) as '年级',\n" +
                "od.num,\n" +
                "CASE mo.express_type\n" +
                "WHEN 1 THEN '顺丰'\n" +
                "WHEN 2 THEN '普通快递'\n" +
                "ELSE '物流' END AS expressType,\n" +
                "CASE\n" +
                "WHEN mi.publish_type = 2\n" +
                "THEN\n" +
                "(\n" +
                "SELECT MIN(gi.goods_num)\n" +
                "FROM mall_combination_item mci, goods_inventory gi\n" +
                "WHERE mci.mall_sku_id = od.mall_sku_id\n" +
                "AND gi.mall_sku_id = mci.relation_mall_sku_id\n" +
                "AND wms_type = 1\n" +
                "AND gi.barCode NOT IN ('LZ', 'YY', 'SX', 'YW')\n" +
                ")\n" +
                "WHEN mi.publish_type = 1\n" +
                "THEN gi.goods_num\n" +
                "ELSE mi.publish_type\n" +
                "END AS goodsNum,\n" +
                "CASE mo.type\n" +
                "WHEN 1 THEN '暂挂'\n" +
                "WHEN 2 THEN '调度'\n" +
                "END zg\n" +
                "FROM mall_order mo\n" +
                "JOIN mall_order_detail od\n" +
                "ON od.order_id = mo.order_id\n" +
                "JOIN mall_sku ms\n" +
                "ON ms.id = od.mall_sku_id\n" +
                "LEFT JOIN goods goo\n" +
                "ON goo.mall_item_id = od.mall_item_id\n" +
                "JOIN mall_item mi\n" +
                "ON mi.id = od.mall_item_id\n" +
                "LEFT JOIN goods_inventory gi\n" +
                "ON gi.mall_sku_id = od.mall_sku_id AND gi.wms_type = 1\n" +
                "WHERE 1 = 1\n" +
                " and mo.sw_order_id='' " +
                "AND mo.sync_status = 0\n" +
                "AND mo.create_time > '2019-11-01'\n" +
                "AND mo.abandon = 0\n" +
                "AND test_ins = 0\n" +
                "AND mo.status IN (1)\n" +
                "AND od.category_code IN ('1000','1027')\n" +
                "      AND grade_id > 0;\n" +
                "";
        ArrayList<String> titles = Lists.newArrayList("order_id", "institution_id", "create_time",
                "spuName", "skuName", "bar_code", "period", "年级", "num", "expressType", "goodsNum", "zg");
        List<Map<String, String>> maps = queryObject(titles, sql);
        ExcelUtil.setSource2Excel2("202005091519_暂挂订单",maps,titles);
    }
}
