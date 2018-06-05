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
 * @author cong
 * @date 2018/6/5
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;


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
    @RequestMapping(value = "modify")
    public ModelAndView modifyProduct(HttpServletRequest request, @RequestParam String productName){
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo(productName);
        Product product = productMapper.selectByExample(example).get(0);
        ModelAndView modelAndView = new ModelAndView("modifyProduct");
        modelAndView.addObject(product);
        return modelAndView;
    }

    @RequestMapping(value = "save")
    public ModelAndView doSave(Product product){
        productMapper.updateByPrimaryKey(product);
        return new ModelAndView("redirect:/product/list");
    }

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
