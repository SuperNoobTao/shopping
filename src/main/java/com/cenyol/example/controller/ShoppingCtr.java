package com.cenyol.example.controller;

import com.cenyol.example.model.ShoppingCartEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.ShoppingCartRepo;
import com.cenyol.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class ShoppingCtr {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    public String cart(ModelMap modelMap, HttpSession httpSession){
        UserEntity user = (UserEntity) httpSession.getAttribute("user");
        if (user==null) {
            return "login";
        }
        List<ShoppingCartEntity> shoppingCartEntityList = shoppingCartRepo.getCartByU(user.getId());

        modelMap.addAttribute("cart",shoppingCartEntityList);

        return "shoppingcart";
    }


    @RequestMapping(value = "/cart/add",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> cart(
            HttpSession httpSession,
            String productname,
            String imgurl,
            String price,
            String productid){
        HashMap<String,String>  map = new HashMap<String, String>();

        UserEntity user = (UserEntity) httpSession.getAttribute("user");

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();

        shoppingCartEntity.setImgurl(imgurl);
        shoppingCartEntity.setUserid(user.getId());
        shoppingCartEntity.setPrice(Double.parseDouble(price));
        shoppingCartEntity.setProductid(Integer.parseInt(productid));
        shoppingCartEntity.setProductname(productname);
        shoppingCartEntity.setUsername(user.getUsername());
        if (shoppingCartService.add(shoppingCartEntity,user.getId())) {
            map.put("code","true");
        }else {
            map.put("code", "false");
        }

        return map;
    }





}
