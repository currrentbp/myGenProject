package com.currentbp.test.spring.propagation.required;

import com.currentbp.common.model.Student;
import com.currentbp.test.LogTest.LogTest;
import com.currentbp.util.all.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/10/15 9:52
 */
@Service("studentImplTest2")
public class StudentImplTest2 {
    private final static Logger logger = LoggerFactory.getLogger(StudentImplTest2.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getList(){
        List<Student> query = jdbcTemplate.query("select * from student", new StudentRowmapper());
        StringUtil.printObject(query);
    }

    @Transactional
    public void insertTwo(){
        logger.info("===>insertTwo start");
        jdbcTemplate.update("insert student(id,`name`) value(3,'3')");
        logger.info("===>insertTwo ,insert two");
        insertOne();
        logger.info("===>insertTwo ,insert one");
        throw new RuntimeException("===>sssssssssssss222222222");
    }
    @Transactional
    public void insertOne() {
        logger.info("===>insertOne start");
        jdbcTemplate.update("insert student(id,`name`) value(2,'2')");
        logger.info("===>insertOne end");
//        throw new RuntimeException("===>sssssssssssss");
    }


    public class StudentRowmapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            return student;
        }
    }
}
