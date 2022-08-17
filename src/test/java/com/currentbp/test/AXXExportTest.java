package com.currentbp.test;

import com.alibaba.fastjson2.JSON;
import com.currentbp.util.all.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 20200602
 */
public class AXXExportTest {


    /**
     * 查询19年的订单详情
     */
    @Test
    public void query19NomalParentOrderDetail() {
        long startTime = System.currentTimeMillis();
        List<String> allDetailIds = StreamUtil.getListByAbstrackPath("C:\\Users\\Administrator\\Desktop\\mallOrderDetailIds_19year.txt");

        ArrayList<String> allTitles = Lists.newArrayList("id", "order_id", "parent_order_id", "status", "consume_amount", "freight", "create_time",
                "update_time", "sendTime", "mall_sku_id", "name", "mall_sku_name", "num", "price", "bar_code", "eas_code", "itemType",
                "slave_sku_id", "totalNum", "slave_name", "slave_sku_name",
                "financialOrderId", "financialDetailId", "financialIncomeType", "financialIncomeTime",
                "financialAidou", "financialGiftAidou", "financialRmb", "financialTotal", "financialStatus", "financialText", "financialStatus2");


        //通过excel获取财务的所有数据
        List<Map<String, String>> financialSources = getFinancialSources();
        System.out.println("===>financialSources's size:" + financialSources.size());

        //通过详情获取商城的数据
        List<Map<String, String>> sources = getSources();

        //简单检查是否每个财务的详情都有对应的商城数据
        Set<String> orderIds = getOrderIdSet(sources);
        Set<String> orderDetailIds = getOrderDetailIdSet(sources);
        Set<String> parentOrderIds = getParentOrderIdSet(sources);
        checkHasEach(allDetailIds, orderIds, orderDetailIds, parentOrderIds);

        //将财务的数据拼接到商城中
        doHandleSource(sources, financialSources);

        //检查财务的金额是否和商城的金额一致
        try {
            checkMoney(sources, financialSources, orderIds, orderDetailIds, parentOrderIds);
        } catch (Exception e) {
            e.printStackTrace();
        }


        long endTime = System.currentTimeMillis();
        System.out.println("===>used time:" + (endTime - startTime) / 1000);
//        List<List<Map<String, String>>> partition1 = ListUtils.partition(sources, 60000);
//        for (int i1 = 0; i1 < partition1.size(); i1++) {
//            ExcelUtil.setSource2Excel2("订单信息_19_" + i1, partition1.get(i1), allTitles);
//        }
        List<List<String>> newTitles = new ArrayList<>(allTitles.size());
        for (String allTitle : allTitles) {
            newTitles.add(Lists.newArrayList(allTitle));
        }

        List<List<Object>> contents = new ArrayList<>(sources.size());
        for (Map<String, String> source : sources) {
            List<Object> eachs = new ArrayList<>(source.size());
            for (int i = 0; i < allTitles.size(); i++) {
                eachs.add(i,source.getOrDefault(allTitles.get(i),""));
            }
            contents.add(eachs);
        }
        EasyExcelUtil.write("19Order.xlsx", newTitles, contents);
        long endTime2 = System.currentTimeMillis();
        System.out.println("===>used time2:" + (endTime2 - startTime) / 1000);

    }

    private void checkMoney(List<Map<String, String>> sources, List<Map<String, String>> financialSources,
                            Set<String> orderIds, Set<String> orderDetailIds, Set<String> parentOrderIds) {
        long startTime = System.currentTimeMillis();
        //订单详情id对应的订单信息
        Map<String, Map<String, String>> detailId2SourcesMap = new HashMap<>();
        //订单号对应的订单信息
        Map<String, Map<String, String>> orderId2SourcesMap = new HashMap<>();
        //父订单号对应的子订单信息
        Map<String, List<Map<String, Map<String, String>>>> parentOrderId2OrderId2DetailMapMap = new HashMap<>();

        for (Map<String, String> source : sources) {
            detailId2SourcesMap.put(source.get("id"), source);

            String parentOrderId = source.get("parent_order_id");
            String orderId = source.get("order_id");
            //不存在父订单号
            if (null == parentOrderId || "".equals(parentOrderId)) {
                if (!orderId2SourcesMap.containsKey(orderId)) {
                    orderId2SourcesMap.put(orderId, source);
                }
            } else {//存在父订单号
                List<Map<String, Map<String, String>>> orderId2DetailMapLists = parentOrderId2OrderId2DetailMapMap.get(parentOrderId);
                if (CollectionUtils.isEmpty(orderId2DetailMapLists)) {//该父订单不存在，则直接插入父订单对应的订单相关信息
                    Map<String, Map<String, String>> orderId2DetailMap1 = new HashMap<>();
                    orderId2DetailMap1.put(orderId, source);
                    parentOrderId2OrderId2DetailMapMap.put(parentOrderId, Lists.newArrayList(orderId2DetailMap1));
                } else {//父订单信息存在，则需要判断子订单信息是否存在
                    boolean flag = false;//默认不存在该子订单
                    for (Map<String, Map<String, String>> orderId2DetailMapList : orderId2DetailMapLists) {
                        if (orderId2DetailMapList.containsKey(orderId)) {//子订单信息存在，则flag标记位已存在
                            flag = true;
                        }
                    }

                    if (!flag) {
                        Map<String, Map<String, String>> orderId2DetailMap2 = new HashMap<>();
                        orderId2DetailMap2.put(orderId, source);
                        orderId2DetailMapLists.add(orderId2DetailMap2);
                    }

                }
            }
        }

        for (Map<String, String> financialSource : financialSources) {
            String financialDetailId = financialSource.get("financialDetailId");
            boolean isParent = financialDetailId.length() > 10 && parentOrderIds.contains(financialDetailId);
            boolean isOrder = financialDetailId.length() > 10 && orderIds.contains(financialDetailId);
            boolean isDetail = financialDetailId.length() < 10 && orderDetailIds.contains(financialDetailId);

            if (!(isParent || isOrder || isDetail)) {
                System.out.println("===>is diff,detailId:" + financialDetailId);
            }
            //如果财务给的是父订单id
            if (isParent) {
                checkParentPrice(financialSource, parentOrderId2OrderId2DetailMapMap);
            }
            if (isOrder) {
                checkOrderPrice(financialSource, orderId2SourcesMap);
            }
            if (isDetail) {
                checkDetailPrice(financialSource, detailId2SourcesMap);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("===>checkPrice used time:" + (endTime - startTime) / 1000);
    }

    private void checkDetailPrice(Map<String, String> financialSource, Map<String, Map<String, String>> detailId2SourcesMap) {
        String financialDetailId = financialSource.get("financialDetailId");
        double financialTotal = Double.parseDouble(financialSource.get("financialTotal"));

        Map<String, String> sourceMap = detailId2SourcesMap.get(financialDetailId);
        int num = Integer.parseInt(sourceMap.get("num"));
        double price = Double.parseDouble(sourceMap.get("price"));

        double totalAmount = MoneyUtil.multiply(price, num, 2);

        if (!MoneyUtil.eq(financialTotal, totalAmount)) {
            System.out.println("===>checkDetailPrice is error! financialDetailId:" + financialDetailId + " financialTotal:" + financialTotal
                    + " totalAmount:" + totalAmount
                    + " sourceMap:" + JSON.toJSONString(sourceMap));
        }
    }

    private void checkOrderPrice(Map<String, String> financialSource, Map<String, Map<String, String>> orderId2SourcesMap) {
        String financialDetailId = financialSource.get("financialDetailId");
        double financialTotal = Double.parseDouble(financialSource.get("financialTotal"));

        double totalAmount = 0D;

        Map<String, String> sourceMap = orderId2SourcesMap.get(financialDetailId);
        double freight = Double.parseDouble(sourceMap.get("freight"));
        double consumeAmount = Double.parseDouble(sourceMap.get("consume_amount"));
        totalAmount = MoneyUtil.add(totalAmount, freight, 2);
        totalAmount = MoneyUtil.add(totalAmount, consumeAmount, 2);

        if (!MoneyUtil.eq(financialTotal, totalAmount)) {
            System.out.println("===>checkOrderPrice is error! financialDetailId:" + financialDetailId + " financialTotal:" + financialTotal
                    + " totalAmount:" + totalAmount
                    + " sourceMap:" + JSON.toJSONString(sourceMap));
        }
    }

    /**
     * 检查父订单对应的金额
     */
    private void checkParentPrice(Map<String, String> financialSource, Map<String, List<Map<String, Map<String, String>>>> parentOrderId2OrderId2DetailMapMap) {
        String financialDetailId = financialSource.get("financialDetailId");
        double financialTotal = Double.parseDouble(financialSource.get("financialTotal"));

        double totalAmount = 0D;
        List<Map<String, Map<String, String>>> orderId2DetailMapMapLists = parentOrderId2OrderId2DetailMapMap.get(financialDetailId);
        //计算父订单下的所有子订单的商品总金额和运费总金额
        for (Map<String, Map<String, String>> orderId2DetailMapMapList : orderId2DetailMapMapLists) {
            for (Map.Entry<String, Map<String, String>> orderId2DetailEntry : orderId2DetailMapMapList.entrySet()) {
                Map<String, String> key2Value = orderId2DetailEntry.getValue();
                double consumeAmount = Double.parseDouble(key2Value.get("consume_amount"));
                double freight = Double.parseDouble(key2Value.get("freight"));
                totalAmount = MoneyUtil.add(totalAmount, consumeAmount, 2);
                totalAmount = MoneyUtil.add(totalAmount, freight, 2);
            }
        }

        if (!MoneyUtil.eq(financialTotal, totalAmount)) {
            System.out.println("===>checkParentPrice is error! financialDetailId:" + financialDetailId + " financialTotal:" + financialTotal
                    + " totalAmount:" + totalAmount
                    + " orderId2DetailMapMapLists:" + JSON.toJSONString(orderId2DetailMapMapLists));
        }
    }

    private void doHandleSource(List<Map<String, String>> sources, List<Map<String, String>> financialSources) {
        Map<String, Map<String, String>> financialResult = new HashMap<>();
        for (Map<String, String> financialSource : financialSources) {
            /*
              List<Map<String, String>> sourceFromExcel = ExcelUtil.getSourceFromExcel("financialSources",
                Lists.newArrayList("financialOrderId", "financialDetailId", "financialIncomeType", "financialIncomeTime",
                        "financialAidou", "financialGiftAidou", "financialRmb", "financialTotal"));
             */
            financialResult.put(financialSource.get("financialDetailId"), financialSource);
        }

        for (Map<String, String> source : sources) {
            String id = source.get("id");
            if (financialResult.containsKey(id)) {
                Map<String, String> map = financialResult.get(id);
                source.putAll(map);
                continue;
            }
            String orderId = source.get("order_id");
            if (financialResult.containsKey(orderId)) {
                Map<String, String> map = financialResult.get(orderId);
                source.putAll(map);
                continue;
            }
            String parentOrderId = source.get("parent_order_id");
            if (financialResult.containsKey(parentOrderId)) {
                Map<String, String> map = financialResult.get(parentOrderId);
                source.putAll(map);
            }
        }
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

    private List<Map<String, String>> getSources() {
        System.out.println("===>query is start!!!");
        long startTime = System.currentTimeMillis();
        List<String> allDetailIds = StreamUtil.getListByAbstrackPath("C:\\Users\\Administrator\\Desktop\\mallOrderDetailIds_19year.txt");
        List<List<String>> partition = ListUtils.partition(allDetailIds, 500);
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

                List<Map<String, String>> maps = JdbcQueryUtil.queryObject(titles, sql);
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
                List<Map<String, String>> maps2 = JdbcQueryUtil.queryObject(titles, sql2);
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
                    List<Map<String, String>> maps3 = JdbcQueryUtil.queryObject(titles, sql3);
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
        System.out.println("===>query mallTrade used time:" + (endTime - startTime) / 1000);

        return result;
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

    private List<Map<String, String>> getFinancialSources() {
        long startTime = System.currentTimeMillis();
        List<Map<Integer, String>> maps = EasyExcelUtil.syncRead("financialSources.xlsx", 0, 1);
        List<String> titles = Lists.newArrayList("financialOrderId", "financialDetailId", "financialIncomeType", "financialIncomeTime",
                "financialAidou", "financialGiftAidou", "financialRmb", "financialTotal", "financialStatus", "financialText", "financialStatus2");
        List<Map<String, String>> sourceFromExcel = new ArrayList<>(maps.size());
        for (Map<Integer, String> map : maps) {
            Map<String,String> each = new HashMap<>();
            for (int i=0;i<titles.size();i++) {
                each.put(titles.get(i),map.getOrDefault(i,""));
            }
            sourceFromExcel.add(each);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("===>getFinancial's source used time:" + (endTime - startTime) / 1000);
        return sourceFromExcel;
    }

    private void checkHasEach(List<String> allDetailIds, Set<String> orderIds, Set<String> orderDetailIds, Set<String> parentOrderIds) {
        for (String allDetailId : allDetailIds) {
            if (!(orderIds.contains(allDetailId) || orderDetailIds.contains(allDetailId) || parentOrderIds.contains(allDetailId))) {
                System.out.println("detailId:" + allDetailId + " is no query's result!!!");
            }
        }
    }


    private Set<String> getOrderIdSet(List<Map<String, String>> sources) {
        Set<String> result = new HashSet<>();
        for (Map<String, String> source : sources) {
            result.add(source.get("order_id"));
        }
        return result;
    }

    private Set<String> getOrderDetailIdSet(List<Map<String, String>> sources) {
        Set<String> result = new HashSet<>();
        for (Map<String, String> source : sources) {
            result.add(source.get("id"));
        }
        return result;
    }

    private Set<String> getParentOrderIdSet(List<Map<String, String>> sources) {
        Set<String> result = new HashSet<>();
        for (Map<String, String> source : sources) {
            result.add(source.get("parent_order_id"));
        }
        return result;
    }
}
