package com.cenyol.example.controller;

import com.cenyol.example.model.ShoppingCartEntity;
import com.cenyol.example.repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shentao on 2017/3/29.
 */
@Controller
public class ShoppingCtr {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @RequestMapping(value = "cart",method = RequestMethod.GET)
    public String cart(ModelMap modelMap,@PathVariable String id){

        List<ShoppingCartEntity> shoppingCartEntityList = shoppingCartRepo.getCartByU(Integer.parseInt(id));

        modelMap.addAttribute("cart",shoppingCartEntityList);

        return "shoppingcart";
    }
}
