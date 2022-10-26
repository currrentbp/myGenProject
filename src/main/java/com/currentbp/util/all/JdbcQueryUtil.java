package com.currentbp.util.all;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.collections4.ListUtils;

/**
 * 原生的jdbc查询数据库
 *
 * @author baopan
 * @createTime 2020/2/10 10:32
 */
public class JdbcQueryUtil {

    private static String url = "jdbc:mysql://rr-2ze3c5e8p8783u87zzo.mysql.rds.aliyuncs.com:3306/mall_trade" +
            "?useUnicode=true&amp;characterEncoding=UTF-8&autoReconnect=true&useSSL=false" +
            "&rewriteBatchedStatements=true&retrieveGeneratedKeys=true&serverTimezone=UTC";
    private static String user = "baopan";
    private static String password = "eGrWbzqX2DapNdITdY9k";

    public<T> List<T> queryObject2(String sql) {

        return null;
    }

    public static List<Map<String, String>> queryObject(List<String> fieldNames, String sql) {
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
    public void t2() {
        String sql = "select * from mall_item limit 10";
        List<Map<String, String>> maps = queryObject(Lists.newArrayList("id", "name", "code"), sql);
        ExcelUtil.setSource2Excel2("mallItem", maps, null);
    }

    @Test
    public void zangguadingdang() {
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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        System.out.println("===>format:"+format);
        ExcelUtil.setSource2Excel2(format+"_暂挂订单", maps, titles);
    }


    @Test
    public void query1() {
        List<String> detailIds = StreamUtil.getListByAbstrackPath("C:\\Users\\Administrator\\Desktop\\mallOrderDetailIds2_2.txt");
        List<List<String>> partition = ListUtils.partition(detailIds, 500);
        List<Map<String, String>> result = new ArrayList<>(100000000);
        ArrayList<String> titles = Lists.newArrayList("id", "order_id", "freight", "consume_amount",
                "institution_id", "time1", "time2", "time3", "status1", "mall_sku_id", "name", "mall_sku_name", "num", "price", "eas_code");
        for (List<String> strings : partition) {
            String smallDetailIds = list2String(strings);
            if (null == smallDetailIds || smallDetailIds.length() == 0) {
                continue;
            }
            String sql = "select md.id,mo1.order_id,mo1.freight,mo1.consume_amount, mo1.institution_id,mo1.create_time as time1,mo1.update_time as time2,min(ot1.create_time) as time3,\n" +
                    "\tif(mo1.`status`=4,'已完成',if(mo1.`status`=1,'待发货',if(mo1.`status`=2,'待收货',if(mo1.`status`=3,'已取消','其他')))) as status1 ,\n" +
                    "\tmd.mall_sku_id,md.name,md.mall_sku_name,md.num,md.price,ms.eas_code\n" +
                    "from mall_order mo1\n" +
                    "inner join mall_order_detail md\n" +
                    "on mo1.order_id=md.order_id \n" +
                    "inner join mall_sku ms\n" +
                    "on md.mall_sku_id=ms.id\n" +
                    "left join order_logistics_track ot1 \n" +
                    "on mo1.order_id = ot1.order_id\n" +
                    "where 1=1 \n" +
                    "and md.id in (\n" +
                    smallDetailIds +
                    ")\n" +
                    "group by md.id";

            List<Map<String, String>> maps = queryObject(titles, sql);
            result.addAll(maps);

            Set<String> orderIds = new HashSet<>();
            for (Map<String, String> map : maps) {
                orderIds.add(map.get("id"));
            }
            for (String string : strings) {
                if (!orderIds.contains(string)) {
                    System.out.println("===>strings:" + JSON.toJSONString(strings) + " string:" + string);
//                    String sql2 = "select md.id,mo1.order_id,mo1.freight,mo1.consume_amount, mo1.institution_id,mo1.create_time as time1,mo1.update_time as time2,min(ot1.create_time) as time3,\n" +
//                            "\tif(mo1.`status`=4,'已完成',if(mo1.`status`=1,'待发货',if(mo1.`status`=2,'待收货',if(mo1.`status`=3,'已取消','其他')))) as status1 ,\n" +
//                            "\tmd.mall_sku_id,md.name,md.mall_sku_name,md.num,md.price,ms.eas_code\n" +
//                            "from mall_order mo1\n" +
//                            "inner join mall_order_detail md\n" +
//                            "on mo1.order_id=md.order_id \n" +
//                            "inner join mall_sku ms\n" +
//                            "on md.mall_sku_id=ms.id\n" +
//                            "left join order_logistics_track ot1 \n" +
//                            "on mo1.order_id = ot1.order_id\n" +
//                            "where 1=1 \n" +
//                            "and mo1.parent_order_id in ('" +
//                            string+
//                            "')\n" +
//                            "group by md.id";
//                    List<Map<String, String>> map2s = queryObject(titles, sql2);
//                    if(CollectionUtils.isEmpty(map2s)){
//                        System.out.println("===>string:"+string);
//                    }
//                    result.addAll(map2s);
                }
            }

        }
        ExcelUtil.setSource2Excel2("订单信息2_2", result, titles);
    }

    /**
     * 查询19年订单相关数据
     */
    @Test
    public void query2() {
        List<String> allDetailIds = StreamUtil.getListByAbstrackPath("C:\\Users\\Administrator\\Desktop\\mallOrderDetailIds_19year.txt");
        doQuery19OrderDetail(allDetailIds);
    }

    private void doQuery19OrderDetail(List<String> strings1) {
        long startTime = System.currentTimeMillis();
        List<List<String>> partition = ListUtils.partition(strings1, 500);
        List<Map<String, String>> result = new ArrayList<>(100000000);
        ArrayList<String> titles = Lists.newArrayList("id", "order_id", "parent_order_id", "status", "consume_amount", "freight", "create_time",
                "update_time", "sendTime", "mall_sku_id", "name", "mall_sku_name", "num", "price", "bar_code", "eas_code", "itemType",
                "slave_sku_id", "totalNum", "slave_name", "slave_sku_name");
        for (List<String> strings : partition) {
            String[] smallDetailIds = list2String2(strings);
            if (null == smallDetailIds) {
                continue;
            }
            String parentOrderIds = smallDetailIds[0];
            String detailIds = smallDetailIds[1];

            //如果长度小于10的则是订单详情id
            if (StringUtils.isNotBlank(detailIds)) {
                String sql = "select md.id,mo.order_id,mo.parent_order_id,mo.status,mo.consume_amount,mo.freight,mo.create_time,mo.update_time,\n" +
                        "(select min(o.create_time) from order_logistics_track o where o.order_id=mo.order_id) as 'sendTime',\n" +
                        "md.mall_sku_id,md.name,md.mall_sku_name,md.num,md.price,md.bar_code,ms.eas_code,if(md.publish_type=1,'单品','组合商品') as 'itemType',\n" +
                        "mcd.slave_sku_id,mcd.slave_num*md.num as 'totalNum',mcd.slave_name,mcd.slave_sku_name\n" +
                        "from mall_order mo inner join mall_order_detail md\n" +
                        "on mo.order_id=md.order_id \n" +
                        "inner join mall_sku ms\n" +
                        "on md.mall_sku_id=ms.id\n" +
                        "left join mall_order_combination_detail mcd\n" +
                        "on mcd.order_id=mo.order_id and mcd.master_sku_id=md.mall_sku_id\n" +
                        "where \n" +
                        " md.id in (" + detailIds + ")\n" +
                        "and md.mall_sku_id != 0";

                List<Map<String, String>> maps = queryObject(titles, sql);
                result.addAll(maps);

                Set<String> existsDetailIds = new HashSet<>();
                for (Map<String, String> map : maps) {
                    existsDetailIds.add(map.get("id"));
                }
                String[] split = detailIds.split(",");
                for (String detailId : split) {
                    if (!existsDetailIds.contains(detailId)) {
                        System.out.println("===>detailId:" + detailId + " is not exists!");
                    }
                }
            }
            //如果是长度大于10的是订单orderId 或者是parentOrderId
            if (StringUtils.isNotBlank(parentOrderIds)) {
                String sql2 = "select md.id,mo.order_id,mo.parent_order_id,mo.status,mo.consume_amount,mo.freight,mo.create_time,mo.update_time,\n" +
                        "(select min(o.create_time) from order_logistics_track o where o.order_id=mo.order_id) as 'sendTime',\n" +
                        "md.mall_sku_id,md.name,md.mall_sku_name,md.num,md.price,md.bar_code,ms.eas_code,if(md.publish_type=1,'单品','组合商品') as 'itemType',\n" +
                        "mcd.slave_sku_id,mcd.slave_num*md.num as 'totalNum',mcd.slave_name,mcd.slave_sku_name\n" +
                        "from mall_order mo inner join mall_order_detail md\n" +
                        "on mo.order_id=md.order_id \n" +
                        "inner join mall_sku ms\n" +
                        "on md.mall_sku_id=ms.id\n" +
                        "left join mall_order_combination_detail mcd\n" +
                        "on mcd.order_id=mo.order_id and mcd.master_sku_id=md.mall_sku_id\n" +
                        "where \n" +
                        " mo.parent_order_id in (" + parentOrderIds + ")\n" +
                        "and md.mall_sku_id != 0";
                List<Map<String, String>> maps2 = queryObject(titles, sql2);
                result.addAll(maps2);

                Set<String> existsParentOrderIds = new HashSet<>();
                for (Map<String, String> map : maps2) {
                    existsParentOrderIds.add(map.get("parent_order_id"));
                }

                List<String> orderIds = new ArrayList<>();
                String[] split2 = parentOrderIds.replace("'", "").split(",");
                for (String parentOrderId : split2) {
                    if (!existsParentOrderIds.contains(parentOrderId)) {
                        orderIds.add(parentOrderId);
                    }
                }

                if (CollectionUtils.isNotEmpty(orderIds)) {
                    String sql3 = "select md.id,mo.order_id,mo.parent_order_id,mo.status,mo.consume_amount,mo.freight,mo.create_time,mo.update_time,\n" +
                            "(select min(o.create_time) from order_logistics_track o where o.order_id=mo.order_id) as 'sendTime',\n" +
                            "md.mall_sku_id,md.name,md.mall_sku_name,md.num,md.price,md.bar_code,ms.eas_code,if(md.publish_type=1,'单品','组合商品') as 'itemType',\n" +
                            "mcd.slave_sku_id,mcd.slave_num*md.num as 'totalNum',mcd.slave_name,mcd.slave_sku_name\n" +
                            "from mall_order mo inner join mall_order_detail md\n" +
                            "on mo.order_id=md.order_id \n" +
                            "inner join mall_sku ms\n" +
                            "on md.mall_sku_id=ms.id\n" +
                            "left join mall_order_combination_detail mcd\n" +
                            "on mcd.order_id=mo.order_id and mcd.master_sku_id=md.mall_sku_id\n" +
                            "where \n" +
                            " mo.order_id in (" + list2String(orderIds) + ")\n" +
                            "and md.mall_sku_id != 0";
                    List<Map<String, String>> maps3 = queryObject(titles, sql3);
                    result.addAll(maps3);

                    Set<String> existsOrderIds = new HashSet<>();
                    for (Map<String, String> map : maps3) {
                        existsOrderIds.add(map.get("order_id"));
                    }

                    for (String orderId : orderIds) {
                        if (!existsOrderIds.contains(orderId)) {
                            System.out.println("===>orderId:" + orderId + " is not exists!");
                        }
                    }
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("used time:"+(endTime-startTime)/1000);
        List<List<Map<String, String>>> partition1 = ListUtils.partition(result, 60000);
        for (int i1 = 0; i1 < partition1.size(); i1++) {
            ExcelUtil.setSource2Excel3("订单信息_19_"+i1, result, titles);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("used time2:"+(endTime2-startTime)/1000);
    }


    /**
     * 查询19年的售后工单信息
     */
    @Test
    public void queryWorkOrder() {
        ArrayList<String> titles = Lists.newArrayList("id", "work_order_code", "old_order_id", "create_time", "update_time", "waybill_num", "isXuni",
                "sendTime", "type", "status", "should_amount", "freight", "mall_sku_id", "barCode", "price", "publish_type",
                "usable_num", "eas_code", "signalSkuId", "signalNum");
        String sql = "select word.id,wor.work_order_code,wor.old_order_id,wor.create_time,wor.update_time,wor.update_time,wor.waybill_num,if(wor.waybill_num like 'xuni%','ture','false') as 'isXuni',\n" +
                "(select min(o.create_time) from order_logistics_track o where o.order_id=wor.old_order_id) as 'sendTime',wor.`type`,wor.`status`,\n" +
                "wor.should_amount,wor.freight,word.mall_sku_id,word.barCode,word.price,word.publish_type,word.usable_num,ms.eas_code,\n" +
                "mci.relation_mall_sku_id as 'signalSkuId',mci.num*word.usable_num as 'signalNum'\n" +
                "from work_order_refund wor inner join work_order_refund_detail word\n" +
                "on wor.work_order_code=word.work_order_code \n" +
                "inner join mall_sku ms\n" +
                "on ms.id=word.mall_sku_id\n" +
                "left join mall_combination_item mci\n" +
                "on word.mall_sku_id=mci.mall_sku_id\n" +
                "where 1=1 \n" +
                "and wor.update_time>='2019-01-01 00:00:00' and wor.update_time<'2020-01-01 00:00:00'";

        List<Map<String, String>> maps = queryObject(titles, sql);
        ExcelUtil.setSource2Excel2("19年售后工单信息", maps, titles);
    }

    private String[] list2String2(List<String> strings) {
        String[] result = new String[]{"", ""};
        if (null == strings || strings.size() == 0) {
            return result;
        }
        String result1 = "";
        String result2 = "";
        for (String string : strings) {
            if (string.length() > 10) {
                result1 = result1 + "'" + string + "',";
            } else {
                result2 = result2 + string + ",";
            }
        }
        if (StringUtils.isNotBlank(result1)) {
            result[0] = result1.substring(0, result1.length() - 1);
        }
        if (StringUtils.isNotBlank(result2)) {
            result[1] = result2.substring(0, result2.length() - 1);
        }
        return result;
    }

    private String list2String(List<String> strings) {
        String result = "";
        if (null == strings || strings.size() == 0) {
            return result;
        }
        for (String string : strings) {
            if (string.length() > 10) {
                result = result + "'" + string + "',";
            } else {
                result = result + string + ",";
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
