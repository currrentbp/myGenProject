package com.currentbp.test.spring.propagation.required;

import com.currentbp.common.model.Student;
import com.currentbp.entry.BusinessException;
import com.currentbp.util.all.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/10/15 9:52
 */
@Service("studentImplTest1")
public class StudentImplTest1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getList(){
        List<Student> query = jdbcTemplate.query("select * from student", new StudentRowmapper());
        StringUtil.printObject(query);
    }

    //默认隔离级别
    @Transactional()
    public void insertTwo(){
        insertOne();
        jdbcTemplate.update("insert student(id,`name`) value(3,'3')");
        throw new RuntimeException("===>sssssssssssss");
    }
    @Transactional()
    public void insertOne() {
        jdbcTemplate.update("insert student(id,`name`) value(2,'2')");
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
