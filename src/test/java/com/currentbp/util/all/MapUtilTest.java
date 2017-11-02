package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.entity.Student;
import com.currentbp.daletou.DaletouEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author current_bp
 * @createTime 20170830
 */
public class MapUtilTest {


    private final static Logger logger = LoggerFactory.getLogger(MapUtilTest.class);

    @Test
    public void getMapByList() throws Exception {

        List<DaletouEntity> daletouEntities = new ArrayList<DaletouEntity>();
        DaletouEntity daletouEntity = new DaletouEntity();
        daletouEntity.setId("1");
        DaletouEntity daletouEntity1 = new DaletouEntity();
        daletouEntity1.setId("2");
        daletouEntities.add(daletouEntity);
        daletouEntities.add(daletouEntity1);

        Map<Integer, DaletouEntity> map = MapUtil.getMapByList(daletouEntities, "id");
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
        Map<Integer, Student> map = MapUtil.getMapByList(students, "id");
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
        Map<Integer, List<Student>> map = MapUtil.getMapListByList(students, "id");
        logger.info("===>map:" + JSON.toJSONString(map));
    }

}