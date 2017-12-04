package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.entity.Chinese;
import com.currentbp.common.entity.Student;
import com.currentbp.daletou.DaletouEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CollectionUtilTest {
    private final static Logger logger = LoggerFactory.getLogger(CollectionUtilTest.class);

    @Test
    public void getFieldListByMethodName() throws Exception {
    }

    @Test
    public void getFieldListByObjectList() throws Exception {
        List<DaletouEntity> daletouEntities = new ArrayList<DaletouEntity>();
        DaletouEntity daletouEntity = new DaletouEntity();
        daletouEntity.setId("1");
        DaletouEntity daletouEntity2 = new DaletouEntity();
        daletouEntity2.setId("2");
        daletouEntities.add(daletouEntity);
        daletouEntities.add(daletouEntity2);

        List<String> id = CollectionUtil.getFieldListByObjectList(daletouEntities, "name", String.class);
        logger.info("===>s:" + JSON.toJSONString(id));
        List<String> ids1 = CollectionUtil.getFieldListByMethodName(daletouEntities, "getName", String.class);
        logger.info("===>ids1:" + JSON.toJSONString(ids1));
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
        List<Integer> id = CollectionUtil.getFieldListByObjectList(chineses, "id", Integer.class);
        logger.info("===>s:" + JSON.toJSONString(id));
        List<Integer> ids1 = CollectionUtil.getFieldListByMethodName(chineses, "getId", Integer.class);
        logger.info("===>ids1:" + JSON.toJSONString(ids1));
    }

    @Test
    public void getMapByList() throws Exception {

        List<DaletouEntity> daletouEntities = new ArrayList<DaletouEntity>();
        DaletouEntity daletouEntity = new DaletouEntity();
        daletouEntity.setId("1");
        DaletouEntity daletouEntity1 = new DaletouEntity();
        daletouEntity1.setId("2");
        daletouEntities.add(daletouEntity);
        daletouEntities.add(daletouEntity1);

        Map<Integer, DaletouEntity> map = CollectionUtil.getMapByList(daletouEntities, "id");
        System.out.println("===>map:" + JSON.toJSONString(map));
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
        Map<Integer, Student> map = CollectionUtil.getMapByList(students, "id");
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
        Map<Integer, List<Student>> map = CollectionUtil.getMapListByList(students, "id");
        logger.info("===>map:" + JSON.toJSONString(map));
    }

}