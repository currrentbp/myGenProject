package com.currentbp.test.javaBaseTest;


import com.currentbp.common.model.Student;
import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.RandomUtil;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * 
 * @author current_bp
 * @createTime 20161201
 *
 */
public class FangxingTest<T> {

	@Test
	public void createFangxingArray(){
        Student student = new Student();
        Student[] students = create(student);
        for (int i=0;i<students.length;i++) {
            Student  student1 = new Student();
            student1.setId(RandomUtil.getRandomNum(100));
            students[i] = student1;
        }
        ListUtil.printList(students);
    }

    public <T> T[] create(T t){
	    return (T[]) Array.newInstance(t.getClass(),20);
    }

	public void fx1(){
		//?表示前面的那个字符出现一次或者0次
		System.out.println("-911".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
	}

}
