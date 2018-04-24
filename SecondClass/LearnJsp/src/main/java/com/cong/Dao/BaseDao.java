package com.cong.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cong
 * @date 2018/4/24
 */
public class BaseDao {
    private PreparedStatement pstms= null;
    private ResultSet rs = null;


    /**
     *
     * @param conn
     * @param sql
     * @param values
     * @return 受影响的行数
     */
    public int exeUpdate(Connection conn,String sql,Object... values){
        int result = 0;
        try {
            pstms = conn.prepareStatement(sql);
            if(values!=null){
                for(int i=0;i<values.length;i++){
                    pstms.setObject(i+1,values[i]);
                }
            }
            result = pstms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet exeQuery(Connection conn,String sql,Object... values){
        try {
            pstms = conn.prepareStatement(sql);
            if(values!=null){
                for(int i=0;i<values.length;i++){
                    pstms.setObject(i+1,values[i]);
                }
            }
            rs = pstms.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
