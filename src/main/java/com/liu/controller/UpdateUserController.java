package com.liu.controller;

import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserController")
public class UpdateUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");

        User upUser=new User();
        upUser.setId(Integer.parseInt(id));
        upUser.setName(name);
        upUser.setGender(gender);
        upUser.setAge(Integer.parseInt(age));
        upUser.setAddress(address);
        upUser.setQq(qq);
        upUser.setEmail(email);

        UserService service=new UserServiceImpl();
        service.updateUser(upUser);

        response.sendRedirect(request.getContextPath()+"/lookUser");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
