package com.liu.service;

import com.liu.domain.Page;
import com.liu.domain.User;

import java.util.Map;

public interface UserService {
    Page<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> pbMap);
}
