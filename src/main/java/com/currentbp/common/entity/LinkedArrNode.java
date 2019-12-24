package com.currentbp.common.entity;

import java.lang.reflect.Array;

/**
 * 链表数组
 * @author baopan
 * @createTime 20191220
 */
public class LinkedArrNode<T> {
    private int index =-1;
    private int max = 20;
    private T[] node;
    private LinkedArrNode next;

    public LinkedArrNode(){}
    public LinkedArrNode(T t){//todo not work
        if(null == this.node) {
            this.node = (T[]) Array.newInstance(t.getClass(), this.max);
        }
        if(this.index+1<this.max) {
            this.index++;
            this.node[this.index] = t;
        }else{
            while(true){
                LinkedArrNode temp = next;
            }
        }
    }


    public static <T> void merge(LinkedArrNode<T> head){

    }

}
