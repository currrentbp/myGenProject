package com.currentbp.algorithm;

/**
 * 二分法查找
 *
 * @author baopan
 * @createTime 20181107
 */
public class BinarySearch {


    public static void main(String[]args){
        int search = BinarySearch.search(7, new int[]{1, 3, 5, 7, 9,10});
        System.out.println(search);
    }

    public static int search(int targe,int[] array){
        return search(targe,array,0,array.length-1);
    }
    public static int search(int targe, int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high || (low == high && array[mid] != targe)) {
            return -1;
        } else if (array[mid] == targe) {
            return mid;
        }

        if (targe < array[mid]) {
            return search(targe, array, low, mid - 1);
        } else {
            return search(targe, array, mid + 1, high);
        }
    }
}
