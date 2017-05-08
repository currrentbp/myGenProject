package com.bp.daletou;

import com.alibaba.fastjson.JSON;
import com.bp.util.all.CheckUtil;
import com.bp.util.all.PropertiesUtil;
import com.bp.util.all.StreamUtil;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 大乐透
 *
 * @author current_bp
 * @createTime 20170503
 */
public class Daletou {
    private Map<String, DaletouEntity> localDaletouHistory = new HashMap<String, DaletouEntity>();
    //排序好的历史IDs:从小到大排序
    private List<Integer> sortDaletouHistoryIds = new ArrayList<Integer>();
    //需要下载的历史IDs
    private List<Integer> needLoadDaletouHistoryIds = new ArrayList<Integer>();


    //==================      init       ===============================================================//
    /*
    1、下载最新的数据，并保存到daletou_history.txt文件中
    2、对daletou_history.txt文件中的数据进行分析，将没有分析的数据写入
    3、获取一个或者多个预测数据
    4、将历史预测数据进行分析，
     */

    /**
     * 更新历史数据，将最新的数据放入该文件
     */
    private void initHistory() {
        //TODO 更新历史数据
    }

    /**
     * 初始化本地的历史数据
     */
    public void initReadDaletouHistory() {
        List<String> daletouHistory = StreamUtil.readFile(
                "E:\\ws\\idea_ws\\myGenProject\\20161223_7\\myGenProject\\src\\main\\resources\\daletou\\daletou_history.txt");
        if (CheckUtil.isEmpty(daletouHistory)) {
            return;
        }

        List<Integer> list = new ArrayList<Integer>();
        Integer[] temp = new Integer[daletouHistory.size()];
        for (int i = 0; i < daletouHistory.size(); i++) {
            String daletou = daletouHistory.get(i);
            try {//如果格式不正确导致错误，则忽略
                String[] daletous = daletou.split(":");
                String[] nums = daletous[1].split(";");
                String reds = nums[0];
                String blues = nums[1];
                String[] reds1 = reds.split(",");
                String[] blues1 = blues.split(",");

                DaletouEntity daletouEntity = new DaletouEntity();
                daletouEntity.setId(daletous[0]);
                daletouEntity.setBlue(getIntArraysByStringArrays(blues1));
                daletouEntity.setRed(getIntArraysByStringArrays(reds1));

                localDaletouHistory.put(daletous[0], daletouEntity);
                temp[i] = Integer.parseInt(daletous[0]);
            } catch (Exception e) {
                continue;
            }
        }

        Arrays.sort(temp);
        sortDaletouHistoryIds = Arrays.asList(temp);
    }

    /**
     * 初始化分析结果，将新添加的历史数据与前N个数据比较，看看结果类似度
     */
    public void initAnalysis() {
        int analysisNum = Integer.parseInt(PropertiesUtil.getInstance("daletou/config").getValueByKey("analysis_num"));
        //对比
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i = 0; i < sortDaletouHistoryIds.size(); i++) {
            if (i < analysisNum) {//如果前面的历史数据不够，就不要参加计算
                concurrentLinkedQueue.add(sortDaletouHistoryIds.get(i));
            } else {//有足够的历史数据计算，则先计算，再删除顶数据，添加新数据
                float[] analysisResults = analysisBeforeLike(getIntegerArrayByObjectArray(concurrentLinkedQueue.toArray()), sortDaletouHistoryIds.get(i));
                System.out.println("id:" + sortDaletouHistoryIds.get(i) + " like:" + JSON.toJSONString(analysisResults));

                //写入文件中
                try {
                    StreamUtil.writeSomethingToFile(""+sortDaletouHistoryIds.get(i)+":"+analysisResults[0]+","+analysisResults[1]+"\n",
                            "E:\\ws\\idea_ws\\myGenProject\\20161223_7\\myGenProject\\src\\main\\resources\\daletou\\daletou_analysis.txt",
                            true);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                concurrentLinkedQueue.remove();
                concurrentLinkedQueue.add(sortDaletouHistoryIds.get(i));
            }
        }
    }


    //======================私有方法====================================//
    private Integer[] getIntegerArrayByObjectArray(Object[] sources) {
        if (null == sources || 0 == sources.length) {
            return null;
        }

        Integer[] result = new Integer[sources.length];

        for (int i = 0; i < sources.length; i++) {
            result[i] = Integer.parseInt(sources[i].toString());
        }

        return result;
    }

    /**
     * 转换格式
     *
     * @param nums 原数据类型
     * @return 新数据类型
     */
    private int[] getIntArraysByStringArrays(String[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            try {
                int num = Integer.parseInt(nums[i]);
                result[i] = num;
            } catch (Exception e) {
                System.out.println("===>getIntArraysByStringArrays: error!! msg:" + e.getMessage());
            }
        }

        return result;
    }

    /**
     * 计算给定的一些历史数据和index的数据的相似度
     *
     * @param historyList 给定的历史数据的列表
     * @param index       需要比较的数据
     * @return 第一个是红色的相似度，第二个是蓝色相似度
     */
    private float[] analysisBeforeLike(Integer[] historyList, Integer index) {
        float[] result = new float[2];

        DaletouEntity indexDaletou = localDaletouHistory.get("" + index);

        for (int i = 0; i < historyList.length; i++) {
            DaletouEntity daletouEntity = localDaletouHistory.get("" + historyList[i]);
            float[] eachLike = analysisEachLike(indexDaletou, daletouEntity);
            result[0] = result[0] + eachLike[0];
            result[1] = result[1] + eachLike[1];
        }

        result[0] = result[0] / historyList.length;
        result[1] = result[1] / historyList.length;

        return result;
    }


    /**
     * 计算当前数字与以前的数字的相似度
     *
     * @param indexDaletou  当前的dlt
     * @param daletouEntity 以前的dlt
     * @return 相似度
     */
    private float[] analysisEachLike(DaletouEntity indexDaletou, DaletouEntity daletouEntity) {
        float[] result = new float[2];

        //红色区
        int redCount = 0;
        for (int i = 0; i < indexDaletou.getRed().length; i++) {
            for (int j = 0; j < daletouEntity.getRed().length; j++) {
                if (indexDaletou.getRed()[i] == daletouEntity.getRed()[j]) {
                    redCount++;
                }
            }
        }
        //蓝色区
        int blueCount = 0;
        for (int i = 0; i < indexDaletou.getBlue().length; i++) {
            for (int j = 0; j < daletouEntity.getBlue().length; j++) {
                if (indexDaletou.getBlue()[i] == daletouEntity.getBlue()[j]) {
                    blueCount++;
                }
            }
        }

        result[0] = ((float) redCount) / 5;
        result[1] = ((float) blueCount) / 5;

        return result;
    }
}
