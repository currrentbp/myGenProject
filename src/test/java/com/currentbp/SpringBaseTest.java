package com.currentbp;

import com.currentbp.test.spring.propagation.required.StudentImplTest1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author baopan
 * @createTime 2020/10/14 18:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class SpringBaseTest {

}
