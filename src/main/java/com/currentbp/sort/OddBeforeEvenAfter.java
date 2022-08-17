package com.currentbp.sort;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现排序功能：将给定的一个排序结构的奇数放到偶数前面，但是原有的数据结构不要改变
 *
 * @author current_bp
 * @createTime 20170624
 */
public class OddBeforeEvenAfter {
    private static Logger logger = LoggerFactory.getLogger(OddBeforeEvenAfter.class);
    /*
    样例输入：
5
1 2 3 4 5
样例输出：
1 3 5 2 4
     */
    /*
    我的思考的解决方式：使用下沉方法
     */

    @Test
    public void testGetSortList(){
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));
        logger.info("===>list:"+ JSON.toJSONString(getSortList(list)));
    }

    /**
     * 获取新的排序后的列表
     *
     * @param oldList 老列表
     * @return 新的列表
     */
    public List<Integer> getSortList(List<Integer> oldList) {
        if (null == oldList || oldList.size() == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();

        for (int i = 0; i < oldList.size(); i++) {
            Integer temp = oldList.get(i);
            if((temp & 1) != 0 ) {
                result.add(temp);
            }else{
                tempList.add(temp);
            }
        }
        result.addAll(tempList);

        return result;
    }
}
