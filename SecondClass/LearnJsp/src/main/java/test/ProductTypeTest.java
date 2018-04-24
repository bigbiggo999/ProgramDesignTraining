package test;

import com.cong.Dao.DBUtil;
import com.cong.entity.ProductType;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author cong
 * @date 2018/4/10
 */
public class ProductTypeTest {

    public Connection conn = null;
    public PreparedStatement pst = null;

    /**
     * 数据库的查
     *
     * */
    @Test
    public void test01() throws SQLException {
        conn = DBUtil.getConn();
        try {
            pst=conn.prepareStatement("SELECT * FROM product.productType WHERE name=?");
            pst.setString(1,"test");
            ResultSet resultSet = pst.executeQuery();
            List<ProductType> productTypes = new ArrayList<>();
            ProductType productType;
           if(resultSet.next()){
               System.out.println(resultSet.getString("type"));
           }
            while (resultSet.next()){
                productType = new ProductType();
                String name = resultSet.getString("name");
                Integer type =Integer.parseInt(resultSet.getString("type"));
                productType.setName(name);
                productType.setType(type);
                productTypes.add(productType);
            }
            System.out.println(productTypes.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
            pst.close();
        }

    }
    /**
     * 数据库的增
     * */
    @Test
    public void test02() throws SQLException {
        conn =DBUtil.getConn();
        try {
            pst= conn.prepareStatement("INSERT INTO product.productType VALUES ('java',11)");
            int rst = pst.executeUpdate();
            if(rst>0){
                System.out.println("succeed");
            }else {
                System.out.println("failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
            pst.close();
        }

    }

    /**
     * 数据库的改
     *
     * */
    @Test
    public void test03() throws SQLException {
        conn = DBUtil.getConn();
        try {
            pst=conn.prepareStatement("UPDATE product.productType SET type=99 WHERE name='java'");
            pst.executeUpdate();
            int rst = pst.executeUpdate();
            if(rst>0){
                System.out.println("succeed");
            }else {
                System.out.println("failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
            pst.close();
        }
    }
    /**
     * 数据库的删
     *
     * */
    @Test
    public void test04() throws SQLException {
        conn =DBUtil.getConn();
        try {
            pst=conn.prepareStatement("DELETE FROM product.productType WHERE type=99");
            pst.executeUpdate();
            int rst = pst.executeUpdate();
            if(rst==0){
                System.out.println("succeed");
            }else{
                System.out.println("failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conn.close();
            pst.close();
        }
    }





}
