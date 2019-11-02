package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.domain.Page;
import com.liu.domain.User;
import com.liu.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public Page<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> pbMap) {
        Page <User> pb=new Page<>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount= dao.findTotalCount(pbMap);
        pb.setTotalPageCount(totalCount);
        int start=(currentPage-1)*rows;
        List<User> dataList=dao.findByPage(start,rows,pbMap);
        pb.setDataList(dataList);
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        System.out.println(pb);
        return pb;
    }
}
