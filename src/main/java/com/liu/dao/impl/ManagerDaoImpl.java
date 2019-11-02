package com.liu.dao.impl;

import com.liu.dao.ManagerDao;
import com.liu.domain.Manager;
import com.liu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ManagerDaoImpl implements ManagerDao {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Manager loginCheck(Manager loginUser) {
        try {
            String sql = "select * from Manager where id=? and password=?";
            Manager manager = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Manager.class), loginUser.getId(), loginUser.getPassword());
            return manager;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
