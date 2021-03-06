package com.cenyol.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FontCtr {
    // 管理员登录
    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "admin/login";//处理完该请求后返回的页面
    }

    // 管理员首页
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "admin/index";
    }

    // 用户登录页
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginui(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "login";
    }
    // 用户注册首页
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerui(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "register";
    }

}
