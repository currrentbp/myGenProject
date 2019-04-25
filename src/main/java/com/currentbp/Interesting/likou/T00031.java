package com.currentbp.Interesting.likou;


import com.currentbp.common.entity.Student;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2019/4/6 9:34
 */
public class T00031 {
    /*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
2,3,1 → 3,1,2
1,1,5 → 1,5,1
     */
    @Test
    public void t3(){
        Map<Integer,String> ss = new HashMap<>();
        ss.put(1,"ssss");
        ss.put(2,"ffff");
        Collection<String> values = ss.values();
        ListUtil.printList(Lists.newArrayList(values));

    }
    @Test
    public void t2(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1111"));
        students.add(new Student(2,"2222"));
        Student student = students.get(0);
        students.remove(0);
        System.out.println(students);
        System.out.println(student);
    }

    @Test
    public void t1() {
        int[] nums4 = new int[]{1,3,2};
        nextPermutation(nums4);
        ListUtil.printList(nums4);
        int[] nums1 = new int[]{1,2,3};
        nextPermutation(nums1);
        ListUtil.printList(nums1);
        int[] nums2 = new int[]{3,2,1};
        nextPermutation(nums2);
        ListUtil.printList(nums2);
        int[] nums3 = new int[]{1,1,5};
        nextPermutation(nums3);
        ListUtil.printList(nums3);
    }

    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        boolean flag = true;
        int index = 0;
        for (int i = 0; i + 1 != nums.length; i++) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                flag = false;
            }
        }

        if (!flag) {
            int temp = nums[index];
            nums[index] = nums[index + 1];
            nums[index + 1] = temp;
        } else {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

    }
}
