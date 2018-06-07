package com.cong.controller;

import com.cong.config.Message;
import com.cong.dao.ProductMapper;
import com.cong.model.Product;
import com.cong.model.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品的一个控制器,包含增删查改
 * @author cong
 * @date 2018/6/5
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping(value = "list")
    public ModelAndView getProduct(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIsNotNull();
        List<Product> productList = productMapper.selectByExample(example);
        modelAndView.addObject(productList);
        return modelAndView;
    }

    /**
     * 新增一个商品
     * @param product 商品
     * @return
     */
    @RequestMapping(value = "add")
    public ModelAndView addProduct(Product product){
        ModelAndView modelAndView = new ModelAndView();
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo(product.getName());
        List<Product> productList = productMapper.selectByExample(example);
        if(productList.size()==0){
            productMapper.insert(product);
            modelAndView.setViewName("redirect:/product/list");
            return modelAndView;
        }else{
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("商品名称重复","/product/list"));
            return modelAndView;
        }
    }

    /**
     * 对商品信息进行修改
     * @param request
     * @param productName 要修改的商品的名字
     * @return
     */
    @RequestMapping(value = "modify")
    public ModelAndView modifyProduct(HttpServletRequest request, @RequestParam String productName){
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo(productName);
        Product product = productMapper.selectByExample(example).get(0);
        ModelAndView modelAndView = new ModelAndView("modifyProduct");
        modelAndView.addObject(product);
        return modelAndView;
    }

    /**
     * 将修改后的商品信息进行保存,
     * @param product 修改后的商品
     * @return modelandview
     */
    @RequestMapping(value = "save")
    public ModelAndView doSave(Product product){
        productMapper.updateByPrimaryKey(product);
        return new ModelAndView("redirect:/product/list");
    }

    /**
     * 删除商品
     * @param id 要删除的商品的id
     * @return 显示商品的list
     */
    @RequestMapping(value = "delete")
    public String deleteProduct(@RequestParam Integer id){
        productMapper.deleteByPrimaryKey(id.toString());
        return "redirect:/product/list";
    }


    @RequestMapping("addProduct")
    public String beforeAdd(){
        return "addProduct";
    }



}
