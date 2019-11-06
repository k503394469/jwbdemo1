package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import com.liu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(Map<String, String[]> pbMap) {
        String sql="select count(*) from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> paramList=new ArrayList<>();
        Set<String> keys = pbMap.keySet();
        for (String keyTemp:keys){
            if ("currentPage".equals(keyTemp)||"rows".equals(keyTemp))
                continue;

            String paramValue = pbMap.get(keyTemp)[0];
            if (paramValue!=null&&!"".equals(paramValue)){
                sb.append(" and "+keyTemp+" like ? ");
                paramList.add("%"+ keyTemp+"%");
            }
        }
        Integer dataCount = jt.queryForObject(sb.toString(), Integer.class, paramList.toArray());
        return dataCount;
    }

    @Override
    public List<User> findByPage(int start,int rows,Map<String, String[]> pbMap) {
        String sql="select * from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> paramList=new ArrayList<>();
        Set<String> keys = pbMap.keySet();
        for (String keyTemp:keys){
            if ("currentPage".equals(keyTemp)||"rows".equals(keyTemp))
                continue;
            String paramValue = pbMap.get(keyTemp)[0];
            if (paramValue!=null&&!"".equals(paramValue)){
                sb.append(" and "+keyTemp+" like ? ");
                paramList.add("%"+ keyTemp+"%");
            }
        }
        sb.append(" limit ?,?");
        paramList.add(start);
        paramList.add(rows);
        return jt.query(sb.toString(),new BeanPropertyRowMapper<>(User.class),paramList.toArray());
    }

    @Override
    public void add(User addUser) {
        String sql="insert into user values(null,?,?,?,?,?,?)";
        jt.update(sql,addUser.getName(),addUser.getGender(),addUser.getAge(),addUser.getAddress(),addUser.getQq(),addUser.getEmail());
    }

    @Override
    public void del(int userId) {
        String sql="delete from user where id=?";
        jt.update(sql,userId);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        return jt.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public void update(User update) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        jt.update(sql,update.getName(),update.getGender(),update.getAge(),update.getAddress(),update.getQq(),update.getEmail(),update.getId());
    }
}
