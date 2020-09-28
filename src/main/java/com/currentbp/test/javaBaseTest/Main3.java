package com.currentbp.test.javaBaseTest;

/**
 * @author baopan
 * @createTime 20180516
 */
public class Main3 {
    private int i = 1;
    private int j = 2;
    private final int getI(){
        return i;
    }
    private int getJ(){
        return j;
    }
    public static void main(String[] args) {
        Main3 m = new Main3();
        int k = m.getI();
        int z = m.getJ();
        System.out.println(k);
        System.out.println(z);
    }
}
/*
D:\soft\java8\bin>javap -c E:\ws\idea_ws\myGenProject\20170705\myGenProject\target\classes\com\currentbp\annotationForTest\Main3.class
Compiled from "Main3.java"
public class com.currentbp.annotationForTest.Main3 {
  public com.currentbp.annotationForTest.Main3();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_1
       6: putfield      #2                  // Field i:I
       9: aload_0
      10: iconst_2
      11: putfield      #3                  // Field j:I
      14: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #4                  // class com/currentbp/annotationForTest/Main3
       3: dup
       4: invokespecial #5                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: invokespecial #6                  // Method getI:()I
      12: istore_2
      13: aload_1
      14: invokespecial #7                  // Method getJ:()I
      17: istore_3
      18: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: iload_2
      22: invokevirtual #9                  // Method java/io/PrintStream.println:(I)V
      25: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
      28: iload_3
      29: invokevirtual #9                  // Method java/io/PrintStream.println:(I)V
      32: return
}
 */
