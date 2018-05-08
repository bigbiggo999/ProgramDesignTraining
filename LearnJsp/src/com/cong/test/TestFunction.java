package com.cong.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.cong.Dao.UserDao;
import com.cong.Util.DBUtil;
import com.cong.entity.User;

public class TestFunction {
	Connection conn = DBUtil.getConn();
	UserDao userdao = new UserDao();
	@Test
	public void testSelect(){
		List<User> userlist = userdao.selectAll(conn);
		System.out.println(userlist);
	}
	
	@Test
	public void testInsert(){
		User user = new User();
		user.setUsername("test11");
		user.setWork("eee");
		user.setPhone("1111");
		user.setGroup("hhh");
		int result = userdao.insertUser(conn, user);
		System.out.println(result);
	}
	@Test
	public void testDelete(){
		User user = new User();
		user.setUsername("test11");
		int row = userdao.deleteUser(conn, user);
		System.out.println(row);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
