package com.currentbp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20180516
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(100000000);
        for (int i = 0; i < 5000000; i++) {
            source.add(i + 1);
        }

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < source.size(); i++) {
            Integer k = source.get(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time:" + (end1 - start1));
    }
}
/*

D:\soft\java8\bin>javap -c E:\ws\idea_ws\myGenProject\20170705\myGenProject\target\classes\com\currentbp\annotationForTest\Main.class
Compiled from "Main.java"
public class com.currentbp.annotationForTest.Main {
  public com.currentbp.annotationForTest.Main();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: ldc           #3                  // int 100000000
       6: invokespecial #4                  // Method java/util/ArrayList."<init>":(I)V
       9: astore_1
      10: iconst_0
      11: istore_2
      12: iload_2
      13: ldc           #5                  // int 5000000
      15: if_icmpge     37
      18: aload_1
      19: iload_2
      20: iconst_1
      21: iadd
      22: invokestatic  #6                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      25: invokeinterface #7,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
      30: pop
      31: iinc          2, 1
      34: goto          12
      37: invokestatic  #8                  // Method java/lang/System.currentTimeMillis:()J
      40: lstore_2
      41: iconst_0
      42: istore        4
      44: iload         4
      46: aload_1
      47: invokeinterface #9,  1            // InterfaceMethod java/util/List.size:()I
      52: if_icmpge     74
      55: aload_1
      56: iload         4
      58: invokeinterface #10,  2           // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      63: checkcast     #11                 // class java/lang/Integer
      66: astore        5
      68: iinc          4, 1
      71: goto          44
      74: invokestatic  #8                  // Method java/lang/System.currentTimeMillis:()J
      77: lstore        4
      79: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
      82: new           #13                 // class java/lang/StringBuilder
      85: dup
      86: invokespecial #14                 // Method java/lang/StringBuilder."<init>":()V
      89: ldc           #15                 // String time:
      91: invokevirtual #16                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      94: lload         4
      96: lload_2
      97: lsub
      98: invokevirtual #17                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
     101: invokevirtual #18                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
     104: invokevirtual #19                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     107: return
}
 */