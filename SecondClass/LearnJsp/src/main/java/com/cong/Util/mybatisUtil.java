package com.cong.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author cong
 * @date 2018/5/8
 */
public class mybatisUtil {
    public static SqlSessionFactory sqlSessionFactory = null;
    public static Reader reader = null;
    static String resource = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory(){
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sqlSessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}
