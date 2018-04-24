package com.cong.servlet;

import com.cong.entity.Admin;
import com.cong.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author cong
 * @date 2018/4/24
 */
public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("op");
        if("reg".equals(action)){
            try {
                doReg(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    public void doReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        UserService userService = new UserService();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int result = userService.registerUser(admin);
        if(result>0){
            response.sendRedirect("login.jsp");
        }else if(result==0){
            out.println("<script>alert('注册失败');history.go(-1);</script>");
        }else{
            out.println("<script>alert('用户名重复');history.go(-1);</script>");
        }
    }

}
