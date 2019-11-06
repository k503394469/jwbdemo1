package com.liu.dao;

import com.liu.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int findTotalCount(Map<String, String[]> pbMap);

    List<User> findByPage(int start,int rows,Map<String, String[]> pbMap);

    void add(User addUser);

    void del(int parseInt);

    User findUserById(int id);

    void update(User update);
}
