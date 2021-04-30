package com.currentbp.util.all;

import com.currentbp.common.model.Student;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210428
 */
public class ElasticSearchUtilTest extends TestCase {

    @Test
    public void testInsert() {
        new ElasticSearchSevenUtil().insert(new Student(8,"baopan"));
    }
}