package com.currentbp.test.java8;

import com.currentbp.common.entity.Functions;
import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/9/26 16:07
 */
public class FunctionTest {
    @Test
    public void t2() {
        Functions.Function0<Student> function0 = () -> {
            return new Student(1, "1");
        };
        Student student = useFunction(function0);
        StringUtil.printObject(student);

        int id = 2;
        Functions.Function1<Student, Integer> function1 = (i) -> {
            return new Student(i, "" + i);
        };
        Student student1 = useFunction1(id, function1);
        StringUtil.printObject(student1);

        id = 3;
        Student student2 = useFunction2(id, "" + id, function2);
        StringUtil.printObject(student2);
    }

    private Functions.Function2<Student, Integer, String> function2 = Student::new;


    private Student useFunction2(int id, String name, Functions.Function2<Student, Integer, String> function2) {
        return function2.apply(id, name);
    }

    private Student useFunction1(int id, Functions.Function1<Student, Integer> function1) {
        return function1.apply(id);
    }

    private Student useFunction(Functions.Function0<Student> function0) {
        return function0.apply();
    }

}
