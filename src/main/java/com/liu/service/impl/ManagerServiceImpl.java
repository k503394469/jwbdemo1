package com.liu.service.impl;

import com.liu.dao.ManagerDao;
import com.liu.dao.impl.ManagerDaoImpl;
import com.liu.domain.Manager;
import com.liu.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public Manager loginCheck(Manager loginUser) {
        ManagerDao dao=new ManagerDaoImpl();
        return dao.loginCheck(loginUser);
    }
}
