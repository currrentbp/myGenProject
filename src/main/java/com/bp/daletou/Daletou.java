package com.bp.daletou;

import com.bp.util.all.CheckUtil;
import com.bp.util.all.StreamUtil;

import java.util.*;

/**
 * 大乐透
 *
 * @author current_bp
 * @createTime 20170503
 */
public class Daletou {
    private Map<String, DaletouEntity> localDaletouHistory = new HashMap<String, DaletouEntity>();
    private List<Integer> sortDaletouHistoryIds = new ArrayList<Integer>();


    //==================      init       ===============================================================//
    /**
     * 更新历史数据，将最新的数据放入该文件
     */
    private void initHistory(){
        //TODO 更新历史数据
    }
    /**
     * 初始化本地的历史数据
     */
    private void initReadDaletouHistory() {
        List<String> daletouHistory = StreamUtil.readFile(
                "E:\\ws\\idea_ws\\myGenProject\\20161223_7\\myGenProject\\src\\main\\resources\\daletou\\daletou_history.txt");
        if (CheckUtil.isEmpty(daletouHistory)) {
            return;
        }

        List<Integer> list = new ArrayList<Integer>();
        Integer[] temp = new Integer[daletouHistory.size()];
        for (int i=0;i<localDaletouHistory.size();i++) {
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

                localDaletouHistory.put(daletous[0],daletouEntity);
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
    private void initAnalysis(){

    }


    //======================私有方法====================================//

    /**
     * 转换格式
     * @param nums 原数据类型
     * @return 新数据类型
     */
    private int[] getIntArraysByStringArrays(String[] nums) {
        int[] result = new int[nums.length];

        for (int i=0;i<nums.length;i++) {
            try {
                int num = Integer.parseInt(nums[i]);
                result[i] = num;
            } catch (Exception e) {
                System.out.println("===>getIntArraysByStringArrays: error!! msg:" + e.getMessage());
            }
        }

        return result;
    }
}
