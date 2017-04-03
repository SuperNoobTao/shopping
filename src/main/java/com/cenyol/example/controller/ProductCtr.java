package com.cenyol.example.controller;

import com.cenyol.example.model.ContentEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.repository.ContentRepo;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by shentao on 2017/3/29.
 */

@Controller
public class ProductCtr {


    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ContentRepo contentRepo;


    // 首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String users(ModelMap modelMap){
        // 热门销售
        List<ProductEntity> productList = productRepo.getProductS(StringUtil.Hot_sale);
        // 智能生活
        List<ProductEntity> productList2 = productRepo.getProductS(StringUtil.Intelligent_life);
        // 限时促销
        List<ProductEntity> productList3 = productRepo.getProductS(StringUtil.Timed_promotion);
        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("productList", productList);
        modelMap.addAttribute("productList2", productList2);
        modelMap.addAttribute("productLis3", productList3);

        // 返回pages目录下的userManage.jsp
        return "index";
    }


    // 用户管理
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String users(ModelMap modelMap,@PathVariable String id){
        ProductEntity productEntity = productRepo.findOne(Integer.valueOf(id));
        List<ContentEntity> contentEntityList = contentRepo.getContentByP(Integer.parseInt(id));

        modelMap.addAttribute("product", productEntity);
        modelMap.addAttribute("contents", contentEntityList);
        return "product";
    }






}
