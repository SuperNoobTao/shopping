package com.cenyol.example.controller.admin;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shentao on 2017/3/30.
 */
@Controller
public class AdminFontCtr {


    @Autowired
    private ProductRepo productRepo;

    // 商品列表
    @RequestMapping(value = "/admin/pro", method = RequestMethod.GET)
    public String proList(ModelMap modelMap){
        // 返回pages目录下的userManage.jsp
        List<ProductEntity> productList = productRepo.findAll();
        modelMap.addAttribute("proList",productList);
        return "admin/product";
    }




    // 商品列表
    @RequestMapping(value = "/admin/pro/add", method = RequestMethod.GET)
    public String proAdd(ModelMap modelMap){


        return "admin/addproduct";
    }


}
