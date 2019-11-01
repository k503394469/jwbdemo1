package com.liu.controller;

import com.liu.dao.impl.ManagerDaoImpl;
import com.liu.domain.Manager;
import com.liu.service.ManagerService;
import com.liu.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String _username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        if ("".equals(verifycode)||verifycode==null||!verifycode.equalsIgnoreCase(checkcode_server)){
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        ManagerService ms=new ManagerServiceImpl();
        Manager loginUser=new Manager();
        loginUser.setId(Integer.parseInt(_username));
        loginUser.setPassword(password);

        Manager checkUser=ms.loginCheck(loginUser);
        if (checkUser!=null){

        }else {
            request.setAttribute("msg","密码或用户名错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
