package com.cong.servlet;

import com.cong.Dao.DBUtil;
import com.cong.entity.Admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cong
 * @date 2018/4/17
 */
@Deprecated
public class DoLogin extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String action = req.getParameter("op");
        if(action.equals("login")){
            try {
                doLogin(resp,req);
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            PrintWriter out = resp.getWriter();
            out.print("<h1>Unknown option</h1>");
        }
        return;
    }
    public void doLogin(HttpServletResponse resp,HttpServletRequest req) throws IOException, SQLException {
        Admin admin = new Admin();
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        if(pwd==null||name==null){
            out.print("<script>alert('密码错误');window.location='login.jsp';</script>");
            return;
        }
        admin.setPassword(pwd);
        admin.setUsername(name);
        Connection conn;
        conn = DBUtil.getConn();
        PreparedStatement pst;
        pst = conn.prepareStatement("SELECT * FROM product.users WHERE username=?");
        pst.setString(1,admin.getUsername());
        ResultSet resultset = pst.executeQuery();
        if(resultset==null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        String rightPwd = new String("");
        while(resultset.next()){
             rightPwd = resultset.getString("password");
        }
        if(rightPwd.equals(admin.getPassword())){
            resp.sendRedirect("index.jsp");
            return;
        }else{
            resp.sendRedirect("login.jsp");
        }
    }

}
