package com.cong.Dao;

import com.cong.entity.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cong
 * @date 2018/4/24
 */
public class UserInfoDao extends BaseDao {
    public int insertUser(Connection conn,Admin user){
        String sql = "insert into users(username,password) values(?,?,?))";
        int row = super.exeUpdate(conn,sql,user.getUsername(),user.getPassword());
        return row;

    }

    public Admin selUserByUsername(Connection conn,String username){
        String sql="select * from users where username=?";
        ResultSet rs = super.exeQuery(conn,sql,username);
        Admin admin = null;
        if(rs!=null){
            try {
                if(rs.next()){
                    admin = new Admin();
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin;
    }
}
