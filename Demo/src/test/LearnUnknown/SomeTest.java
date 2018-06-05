package LearnUnknown;

import com.cong.dao.ProductMapper;
import com.cong.dao.TypeMapper;
import com.cong.model.Type;
import com.cong.model.TypeExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author cong
 * @date 2018/5/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})//加载spring容器
public class SomeTest {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testMybatis(){
//        ProductExample example = new ProductExample();
//        example.createCriteria().andIdIsNotNull();
//        List<Product> productList = productMapper.selectByExample(example);
//        productList.stream().forEach(e-> System.out.println(e.getName()));

        TypeExample example = new TypeExample();
        example.createCriteria().andIdIsNotNull();
        List<Type> typeList = typeMapper.selectByExample(example);
        typeList.forEach(System.out::println);
    }

//    @Test
//    public void testJdbc(){
////        String sql = "insert into city(name, id) VALUES ('liu2','001')";
//        String sql = "select * from world.product";
//        List<Product> productList = jdbcTemplate.query(sql,new ProductMap());
//        productList.stream().forEach(e->{
//            System.out.println(e.getId()+e.getName()+e.getType());
//        });
//    }
}
