package com.cong.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDao {
	private PreparedStatement pstms = null;
	private ResultSet rs = null;
	
	public int exeUpdate(Connection conn,String sql,Object...values){
		int result = 0;
		try {
			pstms = conn.prepareStatement(sql);
			if(values!=null){
				for(int i = 0;i<values.length;i++){
					pstms.setObject(i+1, values[i]);
				}
			}
			result = pstms.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	public ResultSet exeQuery(Connection conn,String sql,Object...values){
		try {
			pstms = conn.prepareStatement(sql);
			if(values!=null){
				for(int i = 0;i<values.length;i++){
					pstms.setObject(i+1, values[i]);
				}
			}
			rs = pstms.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
























