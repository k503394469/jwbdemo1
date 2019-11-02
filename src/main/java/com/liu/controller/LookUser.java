package com.liu.controller;

import com.liu.domain.Page;
import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/lookUser")
public class LookUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="5";
        }

        request.setAttribute("currentPage",currentPage);
        request.setAttribute("rows",rows);
        UserService service=new UserServiceImpl();
        Map<String, String[]> pbMap = request.getParameterMap();
        Page<User> userPage= service.findUserByPage(currentPage,rows,pbMap);

        request.setAttribute("userPage",userPage);
        request.setAttribute("pbMap",pbMap);
        System.out.println(userPage);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
