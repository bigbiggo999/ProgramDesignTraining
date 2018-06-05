package com.cong.controller;

import com.cong.config.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author cong
 * @date 2018/6/5
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public ModelAndView doLogin(HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        ModelAndView modelAndView = new ModelAndView();
        if("admin".equals(name)&&"admin".equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("username",name);
            modelAndView.setViewName("index");
            return modelAndView;
        }else {
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("登录失败","login.jsp"));
            return modelAndView;
        }

    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username",null);
        return "login";
    }
}
