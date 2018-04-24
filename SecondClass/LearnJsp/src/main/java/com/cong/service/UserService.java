package com.cong.service;

import com.cong.Dao.DBUtil;
import com.cong.Dao.UserInfoDao;
import com.cong.entity.Admin;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cong
 * @date 2018/4/24
 */
public class UserService {
    private UserInfoDao dao = new UserInfoDao();
    public boolean login(Admin user){
        boolean result = false;
        Connection conn= DBUtil.getConn();
        Admin real = dao.selUserByUsername(conn,user.getUsername());
        if(real!=null){
            if(real.getPassword().equals(user.getPassword())){
                result=true;
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int registerUser(Admin user){
        int result = 0;
        Connection conn = DBUtil.getConn();
        Admin real = dao.selUserByUsername(conn,user.getUsername());
        if(real ==null){
            result = dao.insertUser(conn,user);
        }else{
            result=-1;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
