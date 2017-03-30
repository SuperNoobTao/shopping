package com.cenyol.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shentao on 2017/3/29.
 */
@Controller
public class FontCtr {
    // 用户登录
    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "admin/login";
    }

    // 管理员首页
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        return "admin/index";
    }
}
