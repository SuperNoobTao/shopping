package com.cenyol.example.controller;

import com.cenyol.example.model.ContentEntity;
import com.cenyol.example.model.FlashEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.ContentRepo;
import com.cenyol.example.repository.FlashRepo;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.service.ProductService;
import com.cenyol.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class ProductCtr {


    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ContentRepo contentRepo;
    @Autowired
    private FlashRepo FlashRepo;

    @Autowired
    private ProductService productService;


    // 首页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String users(ModelMap modelMap, HttpSession httpSession){

        // 热门销售
        List<ProductEntity> productList = productService.prolist(StringUtil.Hot_sale);
        // 智能生活
        List<ProductEntity> productList2 = productService.prolist(StringUtil.Intelligent_life);
        // 限时促销
        List<ProductEntity> productList3 = productService.prolist(StringUtil.Timed_promotion);
        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("productList", productList);
        modelMap.addAttribute("productList2", productList2);
        modelMap.addAttribute("productList3", productList3);

        List<FlashEntity> flashList= FlashRepo.findAll();
        for(int i=0;i<flashList.size();i++){
            FlashEntity flashEntity=flashList.get(i);
            modelMap.addAttribute("flashdetail"+i, flashEntity);
        }

        // 返回pages目录下的userManage.jsp
        return "index";
    }


    // 查看某个商品
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String users(ModelMap modelMap,@PathVariable String id){
        ProductEntity productEntity = productService.findOne(Integer.valueOf(id));
        List<ContentEntity> contentEntityList = contentRepo.getContentByP(Integer.parseInt(id));

        modelMap.addAttribute("product", productEntity);
        modelMap.addAttribute("contents", contentEntityList);
        return "product";
    }



    // 搜索
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(ModelMap modelMap, String name){
        List<ProductEntity> productEntityList = productRepo.findByProductnameLike("%"+name+"%");

        modelMap.addAttribute("product", productEntityList);
        return "searchresult";
    }







}
