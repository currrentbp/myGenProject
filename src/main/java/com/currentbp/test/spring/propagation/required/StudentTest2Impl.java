package com.currentbp.test.spring.propagation.required;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baopan
 * @createTime 2020/10/15 17:00
 */
@Service
public class StudentTest2Impl implements StudentTest2 {
    private final static Logger logger = LoggerFactory.getLogger(StudentTest2Impl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //默认隔离级别
    @Transactional()
    public void insertTwo(){
        logger.info("=======================");
        this.insertOne();
        jdbcTemplate.update("insert student(id,`name`) value(3,'3')");
        throw new RuntimeException("===>sssssssssssss");
    }

    public void insertOne() {
        jdbcTemplate.update("insert student(id,`name`) value(2,'2')");
    }

}
