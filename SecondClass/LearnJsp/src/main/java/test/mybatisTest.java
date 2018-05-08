package test;

import com.cong.Util.mybatisUtil;
import com.cong.entity.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author cong
 * @date 2018/5/8
 */
public class mybatisTest {
    public static SqlSessionFactory sqlSessionFactory = mybatisUtil.getSqlSessionFactory();
    SqlSession session = sqlSessionFactory.openSession();

    @Test
    public void testSelect(){
        Admin admin;
        admin = session.selectOne("AdminMapper.selectByUsername","cong");
        System.out.println(admin.toString());
        if(session!=null){
            session.close();
        }
    }
    @Test
    public void testInsert(){
        Admin admin = new Admin();
        admin.setUsername("test3");
        admin.setPassword("123454321");
        System.out.println(session.insert("AdminMapper.insert",admin));
        session.commit();
        session.close();
    }
    @Test
    public void testUpdate(){
        Admin admin = new Admin();
        admin.setUsername("test3");
        admin.setPassword("999999");
        System.out.println(session.update("AdminMapper.updateByUsername",admin));
        session.commit();
        session.close();
    }
    @Test
    public void testDelete(){
        System.out.println(session.delete("AdminMapper.deleteByUsername","test3"));
        session.commit();
        session.close();
    }
}
