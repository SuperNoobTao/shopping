package com.cenyol.example.controller;

import com.cenyol.example.model.OrderEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.OrderRepo;

import com.cenyol.example.repository.UserRepo;
import com.cenyol.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by shentao on 2017/3/29.
 */
@Controller
public class OrderCtr {

    @Autowired
    OrderService orderService;
    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> order(HttpSession httpSession, String productname, String price, String num, String productid){
        HashMap<String,String>  map = new HashMap<String, String>();

        UserEntity user = (UserEntity) httpSession.getAttribute("user");
        double orderPrice = Double.parseDouble(price)*(Integer.parseInt(num));
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderaddress(user.getAddress());
        orderEntity.setUserid(user.getId());
        orderEntity.setOrderprice(orderPrice);
        orderEntity.setOrdertel(user.getTel());
        orderEntity.setOrdernum(Integer.parseInt(num));
        orderEntity.setProductname(productname);
        orderEntity.setProductid(Integer.valueOf(productid));
        orderEntity.setUsername(user.getUsername());

        httpSession.setAttribute("order",orderEntity);

        map.put("code","true");

        return map;
    }

    @RequestMapping(value = "/order/detail",method = RequestMethod.GET)
    public String orderdetail(){
        return "order";
    }

    @RequestMapping(value = "/order/detail/add",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String>  orderdetailadd(HttpSession httpSession){

        HashMap<String,String>  map = new HashMap<String, String>();
        OrderEntity orderEntity = (OrderEntity) httpSession.getAttribute("order");
        UserEntity user = userRepo.findOne(orderEntity.getUserid());

        if (user.getMoney()<orderEntity.getOrderprice()) {
            map.put("code","false");
        }else {
            orderService.addOrder(orderEntity);
            map.put("code","true");
        }
        return map;
    }

}
