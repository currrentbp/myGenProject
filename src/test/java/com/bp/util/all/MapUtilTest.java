package com.bp.util.all;

import com.alibaba.fastjson.JSON;
import com.bp.daletou.DaletouEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/30.
 */
public class MapUtilTest {
    @Test
    public void getMapByList() throws Exception {

        List<DaletouEntity> daletouEntities = new ArrayList<DaletouEntity>();
        DaletouEntity daletouEntity = new DaletouEntity();
        daletouEntity.setId("1");
        DaletouEntity daletouEntity1 = new DaletouEntity();
        daletouEntity1.setId("2");
        daletouEntities.add(daletouEntity);
        daletouEntities.add(daletouEntity1);

        Map<Integer,DaletouEntity> map = MapUtil.getMapByList(daletouEntities,"id");
        System.out.println("===>map:"+ JSON.toJSONString(map));
    }

}