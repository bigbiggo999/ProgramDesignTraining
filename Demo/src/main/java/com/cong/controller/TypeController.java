package com.cong.controller;

import com.cong.config.Message;
import com.cong.dao.ProductMapper;
import com.cong.dao.TypeMapper;
import com.cong.model.Product;
import com.cong.model.ProductExample;
import com.cong.model.Type;
import com.cong.model.TypeExample;
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
@RequestMapping(value = "type")
public class TypeController {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("add")
    public ModelAndView addType(Type type){
        TypeExample example = new TypeExample();
        example.or().andIdEqualTo(type.getId()).andNameEqualTo(type.getName());
        List<Type> typeResult = typeMapper.selectByExample(example);
        ModelAndView modelAndView = new ModelAndView();
        if(typeResult.size()==0){
            typeMapper.insert(type);
        }else{
            Message message = Message.createErr("插入商品类型错误","/type/list");
            modelAndView.addObject(message);
            modelAndView.setViewName("fail");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/type/list");
        return modelAndView;
    }


    @RequestMapping("list")
    public String getTypes(HttpServletRequest request){
        TypeExample example = new TypeExample();
        example.createCriteria().andIdIsNotNull();
        List<Type> typeList = typeMapper.selectByExample(example);
        request.setAttribute("typeList",typeList);
        return "manageType";
    }

    @RequestMapping(value = "modify")
    public ModelAndView modifyType(HttpServletRequest request, @RequestParam String typeName){
        TypeExample example = new TypeExample();
        example.createCriteria().andNameEqualTo(typeName);
        Type type =  typeMapper.selectByExample(example).get(0);
        ModelAndView modelAndView = new ModelAndView("modify");
        modelAndView.addObject(type);
         return modelAndView;
    }

    @RequestMapping(value = "save")
    public ModelAndView doSave(Type type){
        typeMapper.updateByPrimaryKey(type);
        return new ModelAndView("redirect:/type/list");
    }

    @RequestMapping("delete")
    public ModelAndView deleteType(@RequestParam Integer id){
        ModelAndView modelAndView  = new ModelAndView();
        Type type = typeMapper.selectByPrimaryKey(id);
        ProductExample productExample= new ProductExample();
        productExample.createCriteria().andTypeEqualTo(type.getName());
        List<Product> products = productMapper.selectByExample(productExample);
        if(products.size()!=0){
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("该类别存在商品,不能删除","/type/list"));
            return modelAndView;
        }else {
            typeMapper.deleteByPrimaryKey(id);
            modelAndView.setViewName("redirect:/type/list");
            return modelAndView;
        }
    }


    @RequestMapping("addType")
    public String beforeAdd(){
        return "addType";
    }
}
