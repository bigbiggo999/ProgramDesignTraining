package test;

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
    public static final String className = "com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/product?useSSL=true";
    public static final String name = "root";
    public static final String password="980611";
    public Connection conn = null;
    public PreparedStatement pst = null;

    public Connection getConn() {
        try {
            Class.forName(className);
            conn=DriverManager.getConnection(url,name,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 数据库的查
     *
     * */
    @Test
    public void test01() throws SQLException {
        conn = getConn();
        try {
            pst=conn.prepareStatement("SELECT * FROM product.productType");
            ResultSet resultSet = pst.executeQuery();
            List<ProductType> productTypes = new ArrayList<>();
            ProductType productType;
            while (resultSet.next()){
                productType = new ProductType();
                String name = resultSet.getString("name");
                Integer type =Integer.parseInt(resultSet.getString("type"));
                productType.setName(name);
                productType.setType(type);
                productTypes.add(productType);
            }
            System.out.println(productTypes);
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
        conn = getConn();
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
        conn = getConn();
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
        conn = getConn();
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
