package com.cong.Dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cong.entity.User;

public class UserDao extends BaseDao{
	
	public int insertUser(Connection conn,User user){
		String sql="insert into users(username,work,phone,`group`) values(?,?,?,?)";
		int row = super.exeUpdate(conn, sql, user.getUsername(),user.getWork(),user.getPhone(),user.getGroup());
		return row;
		
	}
	
	public int updateUser(Connection conn,User user,String oldname){
		String sql = "update users set username=?,work=?,phone=?,`group`=? where username = ? ";
		int row = super.exeUpdate(conn, sql, user.getUsername(),user.getWork(),user.getPhone(),user.getGroup(),oldname);
		return row;
	}
	public int deleteUser(Connection conn,User user){
		String sql = "delete from users where username=?";
		int row = super.exeUpdate(conn, sql, user.getUsername());
		return row;
	}
	
	public List<User> selectAll(Connection conn){
		String sql = "select * from users";
		ResultSet rs = null;
		rs = super.exeQuery(conn, sql);
		List<User> userlist = new ArrayList<User>();
		try {
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString(2));
				user.setWork(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroup(rs.getString(7));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
		
	}
	public User selectByName(Connection conn,String username){
		String sql = "select * from users where username = ?";
		ResultSet rs = super.exeQuery(conn, sql, username);
		User user = null;
		try {
			while(rs.next()){
				user.setUsername(rs.getString(2));
				user.setWork(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGroup(rs.getString(7));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
