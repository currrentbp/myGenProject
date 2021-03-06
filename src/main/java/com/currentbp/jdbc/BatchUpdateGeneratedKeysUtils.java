package com.currentbp.jdbc;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author current_bp
 * @createTime 20180408
 */
public class BatchUpdateGeneratedKeysUtils extends BatchUpdateUtils {

    public static int[] executeKeysBatchUpdate(String sql, final List<Object[]> batchValues, final int[] columnTypes,
                                               MyJdbcTemplate myJdbcTemplate, KeyHolder generatedKeyHolder) {
        return myJdbcTemplate.batchUpdate(
                sql,
                new BatchPreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Object[] values = batchValues.get(i);
                        setStatementParameters(values, ps, columnTypes);
                    }

                    @Override
                    public int getBatchSize() {
                        return batchValues.size();
                    }
                },generatedKeyHolder);
    }
}
