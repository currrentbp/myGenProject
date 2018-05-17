package com.currentbp.test;

/**
 * @author baopan
 * @createTime 20180516
 */
public class Main2 {
    public final static int id = 1;
    public static void main(String[] args) {
        int j = 2;
        int k = j+id;
        System.out.println(k);
    }
}
/*
D:\soft\java8\bin>javap -c E:\ws\idea_ws\myGenProject\20170705\myGenProject\target\classes\com\currentbp\test\Main2.class
Compiled from "Main2.java"
public class com.currentbp.test.Main2 {
  public static final int id;

  public com.currentbp.test.Main2();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_2
       1: istore_1
       2: iload_1
       3: iconst_1
       4: iadd
       5: istore_2
       6: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       9: iload_2
      10: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      13: return
}
 */