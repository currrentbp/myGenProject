package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.model.Chinese;
import com.currentbp.common.model.Course;
import com.currentbp.common.model.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CollectionUtilTest {


    private final static Logger logger = LoggerFactory.getLogger(CollectionUtilTest.class);


    @Test
    public void getMapListFromListByMethodName() throws Exception {
        List<Chinese> chineses = new ArrayList<Chinese>();
        for (int i = 0; i < 10; i++) {
            Chinese chinese = new Chinese();
            chinese.setId(i);
            chinese.setName("name_" + i);
            chinese.setColor("yellow");
            chinese.setAge(i);
            chineses.add(chinese);
            chinese.setType(i);
        }
        Chinese chinese = new Chinese();
        chinese.setName("name_" + 1);
        chinese.setId(111111);
        chineses.add(chinese);
        Map<Object, List<Chinese>> mapListFromListByMethodName = CollectionCommonUtil.getMapListFromListByMethodName(chineses, "getName");
        logger.info(JSON.toJSONString(mapListFromListByMethodName));
    }

    @Test
    public void getMapFromListByMethodName() throws Exception {
        List<Chinese> chineses = new ArrayList<Chinese>();
        for (int i = 0; i < 10; i++) {
            Chinese chinese = new Chinese();
            chinese.setId(i);
            chinese.setName("name_" + i);
            chinese.setColor("yellow");
            chinese.setAge(i);
            chineses.add(chinese);
            chinese.setType(i);
        }
        Map<String, Chinese> nameMap = CollectionCommonUtil.getMapFromListByMethodName(chineses, "getName",String.class);
        logger.info(JSON.toJSONString(nameMap));
    }

    @Test
    public void getFieldListByMethodName() throws Exception {
    }

    @Test
    public void getFieldListByObjectList() throws Exception {
    }

    @Test
    public void getFieldListByObjectList2AboutSuperClass() throws Exception {
        List<Chinese> chineses = new ArrayList<Chinese>();
        for (int i = 0; i < 10; i++) {
            Chinese chinese = new Chinese();
            chinese.setId(i);
            chinese.setName("name_" + i);
            chinese.setColor("yellow");
            chinese.setAge(i);
            chineses.add(chinese);
            chinese.setType(i);
        }
        List<Integer> id = CollectionCommonUtil.getFieldListByObjectList(chineses, "id", Integer.class);
        logger.info("===>s:" + JSON.toJSONString(id));
        List<Integer> ids1 = CollectionCommonUtil.getFieldListByMethodName(chineses, "getId", Integer.class);
        logger.info("===>ids1:" + JSON.toJSONString(ids1));
    }

    @Test
    public void getMapByList() throws Exception {

    }

    @Test
    public void getMapByList2() throws Exception {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setId(1);
        student.setName("1");
        students.add(student);
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("2");
        students.add(student2);
        Map<Integer, Student> map = CollectionCommonUtil.getMapByList(students, "id");
        logger.info("===>map:" + JSON.toJSONString(map));

    }

    @Test
    public void getMapListByList() throws Exception {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setId(1);
        student.setName("1");
        students.add(student);
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("2");
        students.add(student2);
        Student student3 = new Student();
        student3.setId(2);
        student3.setName("3");
        students.add(student3);
        Map<Integer, List<Student>> map = CollectionCommonUtil.getMapListByList(students, "id");
        logger.info("===>map:" + JSON.toJSONString(map));
    }

    @Test
    public void asList() {
        Student[] source = new Student[2];
        Student student = new Student();
        student.setId(1);
        student.setName("1");
        source[0] = (student);
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("2");
        source[1] = (student2);

        List<Student> students = CollectionCommonUtil.asList(source, Student.class);
        logger.info(JSON.toJSONString(students));

        Integer[] i = new Integer[2];
        i[0] = 1;
        i[1] = 2;
        List<Integer> integers = CollectionCommonUtil.asList(i, Integer.class);
        logger.info(JSON.toJSONString(integers));

    }

    @Test
    public void setFieldByMethodName() {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(i + 1);
            students.add(student);
        }

        CollectionCommonUtil.setFieldByMethodName(students, "setName", "baopan");
        logger.info("===>" + JSON.toJSONString(students));

        Course course = new Course();
        course.setName("baopan11111");
        CollectionCommonUtil.setFieldByMethodName(students, "setCourse", course);
        logger.info("===>" + JSON.toJSONString(students));

    }

}