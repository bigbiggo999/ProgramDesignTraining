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

    @Test
    public void test01() throws SQLException {

        try {
            Class.forName(className);
            conn= DriverManager.getConnection(url,name,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
