package com.bp.util.all;

import com.alibaba.fastjson.JSON;
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
    public void getListByList() throws Exception {
        List<DaletouEntity> daletouEntities  = new ArrayList<DaletouEntity>();
        DaletouEntity daletouEntity = new DaletouEntity();
        daletouEntity.setId("1");
        DaletouEntity daletouEntity2 = new DaletouEntity();
        daletouEntity2.setId("2");
        daletouEntities.add(daletouEntity);
        daletouEntities.add(daletouEntity2);

        List<Integer> id = ListUtil.getFieldListByObjectList(daletouEntities, "id", Integer.class);
        logger.info("===>s:"+ JSON.toJSONString(id));
        logger.info("===>1==1:"+ (1 == id.get(0)));
    }


}