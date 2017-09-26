package com.bp.util.all;

import com.alibaba.fastjson.JSON;
import com.bp.common.entity.Chinese;
import com.bp.daletou.Daletou;
import com.bp.daletou.DaletouEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/30.
 */
public class ListUtilTest {
    private final static Logger logger = LoggerFactory.getLogger(ListUtilTest.class);


    @Test
    public void fill() throws Exception {
    }

    @Test
    public void fill1() throws Exception {
    }

    @Test
    public void sumNumsFromList() throws Exception {
    }

    @Test
    public void sumNumsFromArray() throws Exception {
    }

    @Test
    public void pureListWithoutNull() throws Exception {
    }

    @Test
    public void reverseList() throws Exception {
    }

    @Test
    public void stringList2IntegerList() throws Exception {
    }

    @Test
    public void stringList2LongList() throws Exception {
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

        List<String> id = ListUtil.getFieldListByObjectList(daletouEntities, "name", String.class);
        logger.info("===>s:" + JSON.toJSONString(id));
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
        }
        List<Integer> id = ListUtil.getFieldListByObjectList(chineses, "age", Integer.class);
        logger.info("===>s:" + JSON.toJSONString(id));
    }
}