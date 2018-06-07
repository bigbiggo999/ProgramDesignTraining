package com.cong.controller;

import com.cong.config.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录的Controller
 * @author cong
 * @date 2018/6/5
 */
@Controller
public class LoginController {
    /**
     * 进行登录,默认用户名和密码为admin
     * @param request
     * @return
     */
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

    /**
     *
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 注销功能
     * @param request
     * @return
     */
    @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username",null);
        return "login";
    }
}
