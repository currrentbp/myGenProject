package com.currentbp.algorithm;

/**
 * 排序工具
 *
 * @author baopan
 * @createTime 20181105
 */
public class SortUtils {

    /**
     * 交换两个元素
     *
     * @param array  数组
     * @param index1 位置1
     * @param index2 位置2
     */
    public static void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * 打印数组
     *
     * @param array 数组
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static boolean isSorted(int[] array){
        return isSorted(array,true);
    }
    public static boolean isSorted(int[] array,boolean isAsc){
        if(null == array || array.length<=1){
            return true;
        }
        int flagValue = array[0];
        for(int i=1;i<array.length;i++){
            int nextValue = array[i];
            //升序
            if(isAsc){
                if(flagValue<nextValue){

                }else{
                    return false;
                }
            }else{//降序
                if(flagValue>nextValue){

                }else{
                    return false;
                }
            }
            flagValue = nextValue;
        }
        return true;
    }
}
