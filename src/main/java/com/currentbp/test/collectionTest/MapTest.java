package com.currentbp.test.collectionTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20210324
 */
public class MapTest {


    @Test
    public void t1() {
        Map<Long, Long> users = new HashMap<>();
        //11111111
        users.put(1L, 1L);
        users.put(2L, 2L);
        //test reset --mixed
        users.put(3L, 3L);
        Map<Long, Long> noRobotUsers = users.entrySet().stream()
                .filter(kv -> kv.getKey() != 2L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        StringUtil.printObject(noRobotUsers);
    }
}
