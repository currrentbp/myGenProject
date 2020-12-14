package com.currentbp.test.spring.propagation.required;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baopan
 * @createTime 2020/10/15 17:00
 */
@Service
public class StudentTest4RequiredImpl implements StudentTest4Required {
    private final static Logger logger = LoggerFactory.getLogger(StudentTest4RequiredImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //默认事务传播级别
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertTwo(){
        logger.info("=======================");
        this.insertOne();
        jdbcTemplate.update("insert student(id,`name`) value(3,'3')");
        throw new RuntimeException("===>sssssssssssss");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertOne() {
        logger.info("this is insert one");
        jdbcTemplate.update("insert student(id,`name`) value(2,'2')");
    }

}
