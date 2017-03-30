package com.cenyol.example.controller.admin;

import com.cenyol.example.Service.SellerService;
import com.cenyol.example.model.SellerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by shentao on 2017/3/29.
 */

@Controller
public class SellerCtr {

    @Autowired
    private SellerService sellerService;

    //用户登陆，登陆成功则刷新页面(未完成，应该把user对象放进session中)
    @RequestMapping(value = "/admin/login" ,method = RequestMethod.POST)
    public String login(String myusername,String mypassword,HttpSession httpSession){

        SellerEntity sellerEntity = sellerService.login(myusername,mypassword);
        if (sellerEntity!=null) {

            httpSession.setAttribute("seller", sellerEntity);
            return "/admin/index";
        }
        return "";
    }



}
