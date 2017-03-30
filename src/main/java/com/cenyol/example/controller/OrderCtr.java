package com.cenyol.example.controller;

import com.cenyol.example.model.UserEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by shentao on 2017/3/29.
 */
public class OrderCtr {


    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String cart(ModelMap modelMap, HttpSession httpSession){
        UserEntity user = (UserEntity) httpSession.getAttribute("user");





        return "shoppingcart";
    }
}
