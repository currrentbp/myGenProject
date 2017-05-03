package com.bp.daletou;

import com.bp.util.all.CheckUtil;
import com.bp.util.all.StreamUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大乐透
 *
 * @author current_bp
 * @createTime 20170503
 */
public class Daletou {
    private Map<String, DaletouEntity> localDaletouHistory = new HashMap<String, DaletouEntity>();


    private void initReadDaletouHistory() {
        List<String> daletouHistory = StreamUtil.readFile(
                "E:\\ws\\idea_ws\\myGenProject\\20161223_7\\myGenProject\\src\\main\\resources\\daletou\\daletou_history.txt");
        if (CheckUtil.isEmpty(daletouHistory)) {
            return;
        }

        for (String daletou : daletouHistory) {
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
            } catch (Exception e) {
                continue;
            }
        }

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
